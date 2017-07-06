package com.test.appframework.common.net;

import com.test.appframework.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created 03/07/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}