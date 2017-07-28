package norman.com.learningproject.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v13.app.FragmentPagerAdapter;

import norman.com.learningproject.MainActivity;
import norman.com.learningproject.R;

/**
 * Created by norman on 7/28/17.
 */

public class LayoutPagerAdapter extends FragmentPagerAdapter {
    private int[] layouts;
    private String[] titles;
    Context ctxt;

    public LayoutPagerAdapter(Context ctxt, FragmentManager manager) {
        super(manager);
        this.ctxt = ctxt;
        layouts = getLayoutsArray(R.array.layouts);
        titles = ctxt.getResources().getStringArray(R.array.titles);
    }

    @Override
    public Fragment getItem(int position) {
        return MainActivity.LayoutFragment.newInstance(layouts[position]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    int[] getLayoutsArray(int arrayResourceId) {
        TypedArray typedArray = ctxt.getResources().obtainTypedArray(arrayResourceId);
        int[] result = new int[typedArray.length()];

        for (int i = 0; i < typedArray.length(); i++) {
            result[i] = typedArray.getResourceId(i, -1);
        }

        return result;
    }
}
