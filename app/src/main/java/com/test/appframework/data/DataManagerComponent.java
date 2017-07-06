package com.test.appframework.data;

import com.test.appframework.ApplicationModule;
import com.test.appframework.common.net.NetComponent;
import com.test.appframework.common.util.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created 06/07/2017.
 */

@ApplicationScope
@Component(dependencies = NetComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {
    DataManager dataManager();
}
