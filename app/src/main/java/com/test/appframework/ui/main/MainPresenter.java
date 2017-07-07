package com.test.appframework.ui.main;

import com.test.appframework.data.DataManager;
import com.test.appframework.data.model.Item;
import com.test.appframework.data.source.DataSource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created 07/07/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private final DataManager mDataManager;
    private final MainContract.View mMainView;

    @Inject
    MainPresenter(DataManager dataManager, MainContract.View mainView) {
        mDataManager = dataManager;
        mMainView = mainView;
    }

    @Inject
    void setupListener() {
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {
        loadAnswers();
    }

    @Override
    public void loadAnswers() {
        mDataManager.loadAnswers(new DataSource.LoadAnswersCallback() {
            @Override
            public void onAnswersLoaded(List<Item> items) {
                mMainView.showAnswers(items);
            }

            @Override
            public void onAnswersLoadError() {

            }

            @Override
            public void onAnswersLoadComplete() {

            }
        });
    }
}
