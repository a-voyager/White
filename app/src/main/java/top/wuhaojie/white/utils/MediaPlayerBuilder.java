package top.wuhaojie.white.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.support.annotation.RawRes;

import java.util.ArrayList;
import java.util.List;

import top.wuhaojie.white.entities.MediaPlayerWrapper;
import top.wuhaojie.white.entities.IMusicItem;

/**
 * 建造者模式
 * Created by wuhaojie on 2016/6/27 22:33.
 */
public class MediaPlayerBuilder {

    private final Context mContext;
    private ArrayList<MediaPlayerWrapper> mMediaPlayers;

    public MediaPlayerBuilder(Context context) {
        this.mContext = context;
        mMediaPlayers = new ArrayList<>();
    }

    public MediaPlayerBuilder addItem(IMusicItem item) {
        MediaPlayer mediaPlayer = MediaPlayer.create(mContext, item.getResId());
        mediaPlayer.setLooping(true);
        mediaPlayer.setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
        mediaPlayer.setOnPreparedListener((mp) -> mp.start());
        mMediaPlayers.add(new MediaPlayerWrapper(mediaPlayer, item));
        return this;
    }

    public MediaPlayerBuilder addItem(@RawRes int resId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(mContext, resId);
        mediaPlayer.setLooping(true);
        mediaPlayer.setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
        mediaPlayer.setOnPreparedListener((mp) -> mp.start());
        mMediaPlayers.add(new MediaPlayerWrapper(mediaPlayer, resId));
        return this;
    }

    public List<MediaPlayerWrapper> build() {
        return mMediaPlayers;
    }
}
