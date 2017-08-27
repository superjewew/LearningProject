package norman.com.learningproject;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import norman.com.learningproject.adapter.LayoutPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupStrictMode();

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(new LayoutPagerAdapter(this, getFragmentManager()));
    }

    public static class LayoutFragment extends Fragment {
        public static final String ARG_LAYOUT = "layout";

        public static LayoutFragment newInstance(int layoutID) {

            Bundle args = new Bundle();
            args.putInt(ARG_LAYOUT, layoutID);

            LayoutFragment fragment = new LayoutFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(getArguments().getInt(ARG_LAYOUT), container, false);
        }
    }

    private void setupStrictMode() {
        StrictMode.ThreadPolicy.Builder builder =
                new StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .penaltyLog();

        if(BuildConfig.DEBUG) {
            builder.penaltyFlashScreen();
        }

        StrictMode.setThreadPolicy(builder.build());
    }
}
