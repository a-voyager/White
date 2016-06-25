package top.wuhaojie.white.base;

import android.os.Bundle;

/**
 * Created by wuhaojie on 2016/6/22 21:04.
 */
public interface IAppView {

    int getLayoutResID();

    void initViews(Bundle savedInstanceState);

}
