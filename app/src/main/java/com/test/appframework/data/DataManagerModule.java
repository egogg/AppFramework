package com.test.appframework.data;

import com.test.appframework.common.util.ApplicationScope;
import com.test.appframework.common.util.Local;
import com.test.appframework.common.util.Remote;
import com.test.appframework.data.source.DataSource;
import com.test.appframework.data.source.local.LocalDataSource;
import com.test.appframework.data.source.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created 06/07/2017.
 */

@Module
abstract class DataManagerModule {
    @ApplicationScope
    @Binds
    @Local
    abstract DataSource provideLocalDataSource(LocalDataSource dataSource);

    @ApplicationScope
    @Binds
    @Remote
    abstract DataSource provideRemoteDataSource(RemoteDataSource dataSource);
}
