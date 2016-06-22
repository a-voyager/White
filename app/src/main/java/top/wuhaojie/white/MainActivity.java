package top.wuhaojie.white;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import butterknife.BindView;
import top.wuhaojie.white.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.iv_bg)
    ImageView mIvBg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout mAppbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

}
