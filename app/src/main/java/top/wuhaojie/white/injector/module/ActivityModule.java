package top.wuhaojie.white.injector.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import top.wuhaojie.white.injector.scope.ActivityScope;
import top.wuhaojie.white.injector.scope.ContextLifeCycle;

/**
 * Created by wuhaojie on 2016/6/25 11:41.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    @ContextLifeCycle("Activity")
    public Context provideContext() {
        return mActivity;
    }
}
