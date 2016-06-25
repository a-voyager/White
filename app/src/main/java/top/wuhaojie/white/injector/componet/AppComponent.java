package top.wuhaojie.white.injector.componet;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import top.wuhaojie.white.base.BaseApplication;
import top.wuhaojie.white.injector.module.AppModule;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;

/**
 * Created by wuhaojie on 2016/6/25 11:32.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    BaseApplication app();
    @ContextLifeCycle("App")
    Context context();
}
