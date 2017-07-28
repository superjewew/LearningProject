package norman.com.learningproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import norman.com.learningproject.adapter.SampleAdapter;

public class ViewPagerFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(new SampleAdapter(this, getFragmentManager()));
    }
}
