package top.wuhaojie.white.utils;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;

import top.wuhaojie.white.entities.MusicItem;

/**
 * Created by wuhaojie on 2016/6/27 22:33.
 */
public class MediaPlayerBuilder {

    private final Context mContext;
    private ArrayList<MediaPlayer> mMediaPlayers = new ArrayList<>();

    public MediaPlayerBuilder(Context context) {
        this.mContext = context;
    }

    public MediaPlayerBuilder addItem(MusicItem item) {
        mMediaPlayers.add(MediaPlayer.create(mContext, item.getResId()));
        return this;
    }

    public MediaPlayerBuilder build() {
        return this;
    }
}
