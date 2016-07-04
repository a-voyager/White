package top.wuhaojie.white;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.List;

import top.wuhaojie.white.entities.impl.MusicItemImpl;
import top.wuhaojie.white.utils.MusicItemFactory;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testMusicFactory() {
        List<MusicItemImpl> musicItems = MusicItemFactory.getInstance().createMusicItems(MusicItemImpl.class, R.raw.rain, R.raw.thunder);
        System.out.println(musicItems.get(1).getResId());
    }

}