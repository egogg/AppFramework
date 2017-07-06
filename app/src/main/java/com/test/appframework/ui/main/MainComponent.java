package com.test.appframework.ui.main;

import com.test.appframework.common.util.ActivityScope;
import com.test.appframework.data.DataManagerComponent;

import dagger.Component;

/**
 * Created 04/07/2017.
 */

@ActivityScope
@Component(dependencies = DataManagerComponent.class, modules = MainModule.class)
interface MainComponent {
    void inject(MainActivity activity);
}
