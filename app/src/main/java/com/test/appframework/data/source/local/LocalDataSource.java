package com.test.appframework.data.source.local;

import com.test.appframework.data.source.DataSource;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created 06/07/2017.
 */

public class LocalDataSource implements DataSource {
    @Inject
    LocalDataSource() {
    }

    @Override
    public void loadAnswers(@NonNull LoadAnswersCallback callback) {

    }
}
