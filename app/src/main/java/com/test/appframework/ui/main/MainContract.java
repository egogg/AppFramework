package com.test.appframework.ui.main;

import com.test.appframework.common.mvp.BasePresenter;
import com.test.appframework.common.mvp.BaseView;
import com.test.appframework.data.model.Item;

import java.util.List;

/**
 * Created 04/07/2017.
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        void showAnswers(List<Item> items);
    }

    interface Presenter extends BasePresenter {
        void loadAnswers();
    }
}
