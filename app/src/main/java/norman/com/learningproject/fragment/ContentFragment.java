package norman.com.learningproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import norman.com.learningproject.R;

/**
 * Created by norman on 7/17/17.
 */

public class ContentFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_content, container, false);
        result.findViewById(R.id.showOther).setOnClickListener(this);
        return result;

    }

    @Override
    public void onClick(View view) {
        ((DynamicFragmentActivity) getActivity()).showOther();
    }
}
