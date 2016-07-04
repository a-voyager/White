package top.wuhaojie.white.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.List;

import top.wuhaojie.white.constant.Constant;
import top.wuhaojie.white.entities.IMediaPlayerState;
import top.wuhaojie.white.entities.MediaPlayerWrapper;
import top.wuhaojie.white.entities.impl.MusicItemImpl;
import top.wuhaojie.white.entities.impl.PlayContext;
import top.wuhaojie.white.utils.MediaPlayerBuilder;
import top.wuhaojie.white.utils.MusicItemFactory;

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

//        mMediaPlayers = new MediaPlayerBuilder(this)
//                .addItem(R.raw.rain)
//                .addItem(R.raw.thunder)
//                .addItem(R.raw.birds)
//                .build();

        MediaPlayerBuilder builder = new MediaPlayerBuilder(this);
        List<MusicItemImpl> musicItems = MusicItemFactory.getInstance().getIMusicItems();
        for (MusicItemImpl musicItem : musicItems) {
            builder.addItem(musicItem);
        }
        mMediaPlayers = builder.build();

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


    public void updateVolLevel(String tag, boolean addVol) {
        for (MediaPlayerWrapper m : mMediaPlayers) {
            MusicItemImpl item = (MusicItemImpl) m.mIMusicItem;
            MediaPlayer player = m.mMediaPlayer;
            if (tag.equals(item.getTag())) {

                int newLevel = (item.getLevel() + (addVol ? 1 : -1)) % 4;

                item.setLevel(newLevel);

                setPlayerVolume(player, newLevel);

                break;
            }
        }
    }

    private void setPlayerVolume(MediaPlayer player, int level) {
        switch (level) {
            case 0:
                player.setVolume(0F, 0F);
                break;
            case 1:
                player.setVolume(0.3F, 0.3F);
                break;
            case 2:
                player.setVolume(0.6F, 0.6F);
                break;
            case 3:
                player.setVolume(1.0F, 1.0F);
                break;
        }
    }

}
