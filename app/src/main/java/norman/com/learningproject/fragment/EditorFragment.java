package norman.com.learningproject.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import norman.com.learningproject.R;

/**
 * Created by norman on 7/18/17.
 */

public class EditorFragment extends Fragment implements EditorInterface {

    public static final String EXTRA_POSITION = "position";

    public static EditorFragment newInstance(int position) {
        EditorFragment f = new EditorFragment();

        Bundle args = new Bundle();
        args.putInt(EXTRA_POSITION, position);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_editor, container, false);

        EditText editor = (EditText) rootView.findViewById(R.id.edit_editor);
        int position = getArguments().getInt(EXTRA_POSITION);
        editor.setHint(getTitle(getActivity(), position));

        return rootView;
    }

    @Override
    public void testMethod() {

    }

    public static String getTitle(Context ctxt, int position) {
        return String.format(ctxt.getString(R.string.hint), position + 1);
    }
}
