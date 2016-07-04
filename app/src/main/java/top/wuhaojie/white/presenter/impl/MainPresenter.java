package top.wuhaojie.white.presenter.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import javax.inject.Inject;

import top.wuhaojie.white.base.IAppView;
import top.wuhaojie.white.constant.Constant;
import top.wuhaojie.white.entities.impl.PauseContext;
import top.wuhaojie.white.entities.impl.PlayContext;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;
import top.wuhaojie.white.presenter.IPresenter;
import top.wuhaojie.white.service.MusicService;
import top.wuhaojie.white.utils.ServiceUtils;
import top.wuhaojie.white.view.IMainView;

/**
 * Created by wuhaojie on 2016/6/25 12:03.
 */
public class MainPresenter implements IPresenter {

    private IMainView mIMainView;
    private Context mContext;

    private MusicService.MusicBinder mMusicBinder;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMusicBinder = (MusicService.MusicBinder) service;
            if (need2SwitchState) switchState();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private boolean need2SwitchState = false;

    @Inject
    public MainPresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onResume() {
        // 如果音频播放服务正在运行 则绑定服务
        bindMusicService();
    }

    private void bindMusicService() {
        if (ServiceUtils.isServiceRun(mContext, Constant.MUSIC_SERVICE_CLASS_NAME)) {
            Intent intent = new Intent(mContext, MusicService.class);
            mContext.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        }
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
        if (ServiceUtils.isServiceRun(mContext, Constant.MUSIC_SERVICE_CLASS_NAME)) {
            mContext.unbindService(mServiceConnection);
        }
    }

    @Override
    public void attachView(IAppView v) {
        mIMainView = (IMainView) v;
    }

    public void fabOnclick(View v) {
        // 如果服务未运行 开启服务
        if (!ServiceUtils.isServiceRun(mContext, Constant.MUSIC_SERVICE_CLASS_NAME)) {
            Intent intent = new Intent(mContext, MusicService.class);
            intent.setAction(MusicService.ACTION_PLAY);
//            mIMainView.showSnackBarMsg(R.string.start_playing);
            mContext.startService(intent);
            bindMusicService();
            need2SwitchState = true;
            return;
        }

        switchState();

    }

    private void switchState() {
        if (mMusicBinder.isPlaying()) {
            mMusicBinder.setState(new PauseContext());
            mIMainView.switch2PauseState();
        } else {
            mMusicBinder.setState(new PlayContext());
            mIMainView.switch2PlayState();
        }
    }


}
