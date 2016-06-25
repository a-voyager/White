package top.wuhaojie.white.injector.componet;

import android.app.Activity;
import android.content.Context;

import dagger.Component;
import top.wuhaojie.white.MainActivity;
import top.wuhaojie.white.injector.module.ActivityModule;
import top.wuhaojie.white.injector.scope.ActivityScope;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;

/**
 * Created by wuhaojie on 2016/6/25 11:43.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

    Activity activity();
    @ContextLifeCycle("Activity")
    Context activityContext();
    @ContextLifeCycle("App")
    Context appContext();
}
