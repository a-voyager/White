package top.wuhaojie.white.utils;

import android.content.Context;
import android.support.annotation.RawRes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import top.wuhaojie.white.R;
import top.wuhaojie.white.entities.IMusicItem;
import top.wuhaojie.white.entities.impl.MusicItemImpl;

/**
 * Created by wuhaojie on 2016/7/4 12:42.
 */
public class MusicItemFactory {

    private static volatile MusicItemFactory mMusicItemFactory;
    private Context mContext;
    private List<MusicItemImpl> mIMusicItems;

    public static MusicItemFactory getInstance() {
        if (mMusicItemFactory == null) {
            synchronized (MusicItemFactory.class) {
                if (mMusicItemFactory == null) {
                    mMusicItemFactory = new MusicItemFactory();
                }
            }
        }
        return mMusicItemFactory;
    }

    private MusicItemFactory() {
    }

    public <T extends IMusicItem> List<T> createMusicItems(Class<T> tClass, @RawRes int... resId) {
        List<T> items = new ArrayList<>();
        Constructor constructor = null;
        try {

            constructor = Class.forName(tClass.getName()).getConstructor(int.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for (int id : resId) {
            try {
                T item = (T) constructor.newInstance(id, "test");
                items.add(item);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return items;
    }


    public void initMusicItems(Context context) {
        mContext = context;
        mIMusicItems = new ArrayList<>();
        mIMusicItems.add(new MusicItemImpl(R.raw.rain, "rain", R.drawable.rain, context.getString(R.string.card_title_rain), 2));
        mIMusicItems.add(new MusicItemImpl(R.raw.thunder, "thunder", R.drawable.thunder, context.getString(R.string.card_title_thunder), 2));
        mIMusicItems.add(new MusicItemImpl(R.raw.birds, "birds", R.drawable.birds, context.getString(R.string.card_title_birds), 2));
    }

    public List<MusicItemImpl> getIMusicItems() {
        if (mIMusicItems == null || mIMusicItems.size() <= 0) initMusicItems(mContext);
        return mIMusicItems;
    }

}
