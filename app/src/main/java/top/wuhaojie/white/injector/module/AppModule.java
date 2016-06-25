package top.wuhaojie.white.injector.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import top.wuhaojie.white.base.BaseApplication;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;

/**
 * Created by wuhaojie on 2016/6/25 10:55.
 */
@Module
public class AppModule {

    private BaseApplication mBaseApplication;

    public AppModule(BaseApplication baseApplication) {
        mBaseApplication = baseApplication;
    }

    @Provides
    @Singleton
    public BaseApplication provideBaseApplication() {
        return mBaseApplication;
    }

    @Provides
    @Singleton
    @ContextLifeCycle("App")
    public Context provideAppContext(){
        return mBaseApplication.getApplicationContext();
    }

}
