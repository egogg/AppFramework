package com.test.appframework.ui.main;

import com.test.appframework.common.util.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created 04/07/2017.
 */

@Module
class MainModule {
    private final MainContract.View mView;

    public MainModule(MainContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainContractView() {
        return mView;
    }
}
