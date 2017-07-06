package com.test.appframework;

import android.app.Application;

import com.test.appframework.common.net.DaggerNetComponent;
import com.test.appframework.common.net.NetComponent;
import com.test.appframework.common.net.NetModule;
import com.test.appframework.data.DaggerDataManagerComponent;
import com.test.appframework.data.DataManagerComponent;

/**
 * Created 03/07/2017.
 */

public class FrameworkApplication extends Application {
    private NetComponent mNetComponent;
    private DataManagerComponent mDataManagerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("https://api.stackexchange.com/2.2/"))
                .build();
        mDataManagerComponent = DaggerDataManagerComponent.builder()
                .netComponent(mNetComponent)
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
    public DataManagerComponent getDataManagerComponent() {
        return mDataManagerComponent;
    }
}
