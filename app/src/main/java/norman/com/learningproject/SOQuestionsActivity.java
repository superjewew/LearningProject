package norman.com.learningproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import norman.com.learningproject.fragment.QuestionsFragment;

public class SOQuestionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getFragmentManager().findFragmentById(android.R.id.content) == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, new QuestionsFragment())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onQuestionClickedEvent(QuestionClickedEvent event) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(event.item.link)));
    }
}
