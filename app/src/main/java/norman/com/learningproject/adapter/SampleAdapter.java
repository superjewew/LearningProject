package norman.com.learningproject.adapter;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import norman.com.learningproject.fragment.EditorFragment;

/**
 * Created by norman on 7/18/17.
 */

public class SampleAdapter extends FragmentPagerAdapter {

    Context ctxt;

    public SampleAdapter(Context ctxt, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.ctxt = ctxt;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Fragment getItem(int position) {
        return EditorFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return EditorFragment.getTitle(ctxt, position);
    }
}
