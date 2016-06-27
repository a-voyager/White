package top.wuhaojie.white.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;

import top.wuhaojie.white.R;
import top.wuhaojie.white.constant.Constant;

public class MusicService extends Service {

    private MediaPlayer mMediaPlayer;
    public static final String ACTION_PLAY = Constant.MUSIC_START_ACTION;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initMediaPlayer();
    }

    private void initMediaPlayer() {
        mMediaPlayer = MediaPlayer.create(this, R.raw.rain);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK);
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction().equals(ACTION_PLAY)) {
            if (mMediaPlayer == null) initMediaPlayer();

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying())
            mMediaPlayer.release();
        mMediaPlayer = null;
    }
}
