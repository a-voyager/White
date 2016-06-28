package top.wuhaojie.white.entities;

import android.media.MediaPlayer;

import top.wuhaojie.white.entities.impl.MusicItemImpl;

/**
 * 装饰者模式
 * Created by wuhaojie on 2016/6/28 12:52.
 */
public class MediaPlayerWrapper {
    public final MediaPlayer mMediaPlayer;
    public final MusicItem mMusicItem;


    public MediaPlayerWrapper(MediaPlayer mediaPlayer, MusicItem musicItem) {
        mMediaPlayer = mediaPlayer;
        mMusicItem = musicItem;
    }

    public MediaPlayerWrapper(MediaPlayer mediaPlayer, int resId) {
        mMediaPlayer = mediaPlayer;
        mMusicItem = new MusicItemImpl(resId);
    }

    public MediaPlayerWrapper(MediaPlayer mediaPlayer, String tag) {
        mMediaPlayer = mediaPlayer;
        mMusicItem = new MusicItemImpl(tag);
    }
}
