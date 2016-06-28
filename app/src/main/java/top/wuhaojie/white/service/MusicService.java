package top.wuhaojie.white.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.List;

import top.wuhaojie.white.R;
import top.wuhaojie.white.constant.Constant;
import top.wuhaojie.white.entities.IMediaPlayerState;
import top.wuhaojie.white.entities.MediaPlayerWrapper;
import top.wuhaojie.white.entities.impl.PlayContext;
import top.wuhaojie.white.utils.MediaPlayerBuilder;

public class MusicService extends Service {

    public static final String ACTION_PLAY = Constant.MUSIC_START_ACTION;

    private IMediaPlayerState mMediaPlayerState;

    private MusicBinder mMusicBinder = new MusicBinder();
    private List<MediaPlayerWrapper> mMediaPlayers;

    public MusicService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return mMusicBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initMediaPlayer();
    }

    private void initMediaPlayer() {

        mMediaPlayers = new MediaPlayerBuilder(this)
                .addItem(R.raw.rain)
                .addItem(R.raw.thunder)
                .addItem(R.raw.birds)
                .build();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        for (MediaPlayerWrapper m : mMediaPlayers) {
            if (m != null && m.mMediaPlayer.isPlaying()) {
                m.mMediaPlayer.release();
            }
        }
        super.onDestroy();
    }

    public class MusicBinder extends Binder {
        public IMediaPlayerState getMediaPlayerState() {
            return mMediaPlayerState;
        }

        public void setState(IMediaPlayerState state) {
            mMediaPlayerState = state;
            invalidate();
        }

        public boolean isPlaying() {
            return mMediaPlayerState instanceof PlayContext;
        }

        public void pause() {
            for (MediaPlayerWrapper mediaPlayerWrapper : mMediaPlayers) {
                mediaPlayerWrapper.mMediaPlayer.stop();
                Log.d(getClass().getSimpleName(), "暂停" + mediaPlayerWrapper.mMediaPlayer.toString());
            }
        }

    }


    private void invalidate() {
        mMediaPlayerState.currAction(mMediaPlayers);
    }

}
