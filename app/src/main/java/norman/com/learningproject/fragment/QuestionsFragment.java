package norman.com.learningproject.fragment;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import norman.com.learningproject.Item;
import norman.com.learningproject.LoadThread;
import norman.com.learningproject.QuestionClickedEvent;
import norman.com.learningproject.QuestionsLoadedEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new LoadThread().start();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public QuestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Item item = ((ItemsAdapter) getListAdapter()).getItem(position);
        EventBus.getDefault().post(new QuestionClickedEvent(item));
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onQuestionsLoadedEvent(QuestionsLoadedEvent event) {
        setListAdapter(new ItemsAdapter(event.questions.items));
    }

    private class ItemsAdapter extends ArrayAdapter<Item> {

        ItemsAdapter(List<Item> items) {
            super(getActivity(), android.R.layout.simple_list_item_1, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = super.getView(position, convertView, parent);

            TextView title = (TextView) row.findViewById(android.R.id.text1);

            title.setText(Html.fromHtml(getItem(position).title));

            return row;
        }
    }


}
