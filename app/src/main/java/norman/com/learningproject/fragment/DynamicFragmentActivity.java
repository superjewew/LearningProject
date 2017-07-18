package norman.com.learningproject.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import norman.com.learningproject.fragment.ContentFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dynamic_fragment);
        if(getFragmentManager().findFragmentById(android.R.id.content) == null) {
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, new ContentFragment())
                    .commit();
        }
    }

    public void showOther() {

    }
}
