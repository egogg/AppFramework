package com.test.appframework.ui.main;

import com.test.appframework.common.mvp.BasePresenter;
import com.test.appframework.common.mvp.BaseView;

/**
 * Created 04/07/2017.
 */

interface MainContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
