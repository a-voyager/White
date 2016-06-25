package top.wuhaojie.white.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import top.wuhaojie.white.injector.componet.AppComponent;
import top.wuhaojie.white.injector.componet.DaggerAppComponent;
import top.wuhaojie.white.injector.interfaces.IConfigInjector;
import top.wuhaojie.white.injector.module.AppModule;


/**
 * Created by wuhaojie on 2016/6/22 19:44.
 */
public class BaseApplication extends Application implements IConfigInjector {


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Fresco图片加载库
        Fresco.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    @Override
    public void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


}
