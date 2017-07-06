package com.test.appframework.data.source;

import com.test.appframework.data.model.Item;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created 06/07/2017.
 */

public interface DataSource {
    interface LoadAnswersCallback {
        void onAnswersLoaded(List<Item> items);
        void onAnswersLoadError();
        void onAnswersLoadComplete();
    }

    void loadAnswers(@NonNull LoadAnswersCallback callback);
}
