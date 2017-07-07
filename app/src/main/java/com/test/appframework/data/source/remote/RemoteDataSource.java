package com.test.appframework.data.source.remote;

import android.util.Log;

import com.test.appframework.data.model.Item;
import com.test.appframework.data.model.SOAnswersResponse;
import com.test.appframework.data.source.DataSource;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created 06/07/2017.
 */

public class RemoteDataSource implements DataSource {
    private Retrofit mRetrofit;
    private SOService mSOService;

    @Inject
    RemoteDataSource(Retrofit retrofit) {
        mRetrofit = retrofit;

        mSOService = mRetrofit.create(SOService.class);
    }

    @Override
    public void loadAnswers(final @NonNull LoadAnswersCallback callback) {
        mSOService.getAnswers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SOAnswersResponse>() {
                    @Override
                    public void accept(@NonNull SOAnswersResponse soAnswersResponse) throws Exception {
                        callback.onAnswersLoaded(soAnswersResponse.getItems());
                    }
                });
    }
}
