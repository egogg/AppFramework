package com.test.appframework.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.test.appframework.FrameworkApplication;
import com.test.appframework.R;
import com.test.appframework.common.util.ActivityUtils;
import com.test.appframework.data.DataManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.frame_content);
        if(mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.frame_content);
        }

        DaggerMainComponent.builder()
                .dataManagerComponent(((FrameworkApplication) getApplication()).getDataManagerComponent())
                .mainModule(new MainModule(mainFragment))
                .build()
                .inject(this);
    }
}
