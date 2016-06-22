package top.wuhaojie.white.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wuhaojie on 2016/6/22 19:44.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Fresco图片加载库
        Fresco.initialize(this);
    }
}
