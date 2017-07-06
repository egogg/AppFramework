package com.test.appframework.data;

import com.test.appframework.common.util.ApplicationScope;
import com.test.appframework.common.util.Local;
import com.test.appframework.common.util.Remote;
import com.test.appframework.data.source.DataSource;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created 06/07/2017.
 */

@ApplicationScope
public class DataManager implements DataSource {
    private final DataSource mLocalDataSource;
    private final DataSource mRemoteDataSource;

    @Inject
    DataManager(@Local DataSource localDataSource,
                @Remote DataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void loadAnswers(@NonNull LoadAnswersCallback callback) {
        mRemoteDataSource.loadAnswers(callback);
    }
}
