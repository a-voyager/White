package top.wuhaojie.white.utils;

import android.support.annotation.RawRes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import top.wuhaojie.white.entities.IMusicItem;

/**
 * Created by wuhaojie on 2016/7/4 12:42.
 */
public class MusicItemFactory {
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

}
