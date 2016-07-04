package top.wuhaojie.white.entities.impl;

import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;

import top.wuhaojie.white.entities.IMusicItem;

/**
 * Created by wuhaojie on 2016/6/28 12:37.
 */
public class MusicItemImpl implements IMusicItem {

    @RawRes
    private final int mResId;
    private final String mTag;
    @DrawableRes
    private final int mIconResId;
    private int mLevel;
    private final String mTitle;

    public MusicItemImpl(int resId) {
        mResId = resId;
        mTag = "";
        mTitle = "";
        mIconResId = 0;
    }

    public MusicItemImpl(String tag) {
        mTag = tag;
        mResId = 0;
        mIconResId = 0;
        mTitle = "";
    }

    public MusicItemImpl(int resId, String tag) {
        mResId = resId;
        mTag = tag;
        mTitle = "";
        mIconResId = 0;
    }

    public MusicItemImpl(int resId, String tag, int iconResId, String title, int level) {
        mResId = resId;
        mTag = tag;
        mIconResId = iconResId;
        mTitle = title;
        mLevel = level;
    }

    @Override
    public int getResId() {
        return mResId;
    }

    public String getTag() {
        return mTag;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public int getLevel() {
        return mLevel;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setLevel(int level) {
        mLevel = level;
    }
}
