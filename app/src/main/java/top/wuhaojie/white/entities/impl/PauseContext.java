package top.wuhaojie.white.entities.impl;

import java.util.List;

import top.wuhaojie.white.entities.IMediaPlayerState;
import top.wuhaojie.white.entities.MediaPlayerWrapper;

/**
 * Created by wuhaojie on 2016/6/28 14:24.
 */
public class PauseContext implements IMediaPlayerState {
    @Override
    public void currAction(List<MediaPlayerWrapper> list) {
        if (list == null || list.size() <= 0) throw new IllegalArgumentException("传入参数为空");
        for (MediaPlayerWrapper mediaPlayerWrapper : list) {
            if (mediaPlayerWrapper != null && mediaPlayerWrapper.mMediaPlayer != null && mediaPlayerWrapper.mMediaPlayer.isPlaying()) {
                mediaPlayerWrapper.mMediaPlayer.pause();
            }
        }
    }
}
