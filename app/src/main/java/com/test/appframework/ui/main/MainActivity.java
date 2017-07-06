package com.test.appframework.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.appframework.FrameworkApplication;
import com.test.appframework.R;
import com.test.appframework.data.DataManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent mainComponent = DaggerMainComponent.builder()
                .dataManagerComponent(((FrameworkApplication) getApplication()).getDataManagerComponent())
                .build();
        mainComponent.inject(this);
    }
}
