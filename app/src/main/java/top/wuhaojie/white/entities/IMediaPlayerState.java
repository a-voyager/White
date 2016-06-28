package top.wuhaojie.white.entities;

import java.util.List;

/**
 * 媒体播放状态接口
 * <使用'状态设计模式'>
 * Created by wuhaojie on 2016/6/28 14:20.
 */
public interface IMediaPlayerState {
    void currAction(List<MediaPlayerWrapper> list);
}
