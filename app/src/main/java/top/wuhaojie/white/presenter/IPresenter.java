package top.wuhaojie.white.presenter;

import android.os.Bundle;

import top.wuhaojie.white.base.IAppView;

/**
 * Created by wuhaojie on 2016/6/25 12:02.
 */
public interface IPresenter {
    void onCreate(Bundle savedInstanceState);

    void onResume();

    void onStart();

    void onPause();

    void onStop();

    void onDestroy();

    void attachView(IAppView v);
}
