package com.test.appframework.data.source.remote;

import com.test.appframework.data.model.SOAnswersResponse;
import com.test.appframework.data.source.DataSource;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<SOAnswersResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SOAnswersResponse soAnswersResponse) {
                        callback.onAnswersLoaded(soAnswersResponse.getItems());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onAnswersLoadError();
                    }

                    @Override
                    public void onComplete() {
                        callback.onAnswersLoadComplete();
                    }
                });
    }
}
