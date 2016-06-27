package top.wuhaojie.white.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import top.wuhaojie.white.R;
import top.wuhaojie.white.base.IAppView;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;
import top.wuhaojie.white.presenter.IPresenter;
import top.wuhaojie.white.service.MusicService;
import top.wuhaojie.white.view.IMainView;

/**
 * Created by wuhaojie on 2016/6/25 12:03.
 */
public class MainPresenter implements IPresenter {

    private IMainView mIMainView;
    private Context mContext;

    @Inject
    public MainPresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(IAppView v) {
        mIMainView = (IMainView) v;
    }

    public void fabOnclick(View v) {
        Intent intent = new Intent(mContext, MusicService.class);
        intent.setAction(MusicService.ACTION_PLAY);
        mIMainView.showSnackBarMsg(R.string.presenter_test_msg);
        mContext.startService(intent);
    }
}
