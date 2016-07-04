package top.wuhaojie.white.entities.impl;

import android.support.annotation.RawRes;

import top.wuhaojie.white.entities.IMusicItem;

/**
 * Created by wuhaojie on 2016/6/28 12:37.
 */
public class MusicItemImpl implements IMusicItem {

    @RawRes
    private final int mResId;
    private final String mTag;


    public MusicItemImpl(int resId) {
        mResId = resId;
        mTag = "";
    }

    public MusicItemImpl(String tag) {
        mTag = tag;
        mResId = 0;
    }

    public MusicItemImpl(int resId, String tag) {
        mResId = resId;
        mTag = tag;
    }

    @Override
    public int getResId() {
        return mResId;
    }
}
