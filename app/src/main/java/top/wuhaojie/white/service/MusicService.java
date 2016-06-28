package top.wuhaojie.white.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;

import java.util.List;

import top.wuhaojie.white.R;
import top.wuhaojie.white.constant.Constant;
import top.wuhaojie.white.entities.MediaPlayerWrapper;
import top.wuhaojie.white.utils.MediaPlayerBuilder;

public class MusicService extends Service {

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

        List<MediaPlayerWrapper> mediaPlayers = new MediaPlayerBuilder(this)
                .addItem(R.raw.rain)
                .addItem(R.raw.thunder)
                .addItem(R.raw.birds)
                .build();

        for (MediaPlayerWrapper mediaPlayerWrapper : mediaPlayers) {
            mediaPlayerWrapper.mMediaPlayer.setLooping(true);
            mediaPlayerWrapper.mMediaPlayer.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK);
            mediaPlayerWrapper.mMediaPlayer.setOnPreparedListener((mp) -> mp.start());
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction().equals(ACTION_PLAY)) {

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (mMediaPlayer != null && mMediaPlayer.isPlaying())
//            mMediaPlayer.release();
//        mMediaPlayer = null;
    }
}
