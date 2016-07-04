package top.wuhaojie.white.view;

import android.support.annotation.StringRes;

import top.wuhaojie.white.base.IAppView;

/**
 * Created by wuhaojie on 2016/6/25 12:05.
 */
public interface IMainView extends IAppView {
    void showSnackBarMsg(@StringRes int msg);

    void switch2PauseState();

    void switch2PlayState();

    void addLevel(SwitchView view);

    void closeDrawer();
}
