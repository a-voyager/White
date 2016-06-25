package top.wuhaojie.white;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import top.wuhaojie.white.base.BaseActivity;
import top.wuhaojie.white.base.BaseApplication;
import top.wuhaojie.white.injector.componet.ActivityComponent;
import top.wuhaojie.white.injector.componet.DaggerActivityComponent;
import top.wuhaojie.white.injector.module.ActivityModule;
import top.wuhaojie.white.presenter.impl.MainPresenter;
import top.wuhaojie.white.utils.SnackBarUtils;
import top.wuhaojie.white.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView {


    @BindView(R.id.iv_bg)
    ImageView mIvBg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout mAppbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.left_drawer)
    ListView mLeftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActivityComponent mActivityComponent;

    @OnClick(R.id.fab)
    void fabOnclick(View v) {
        mMainPresenter.fabOnclick(v);
    }

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void initPresenter() {
        mMainPresenter.attachView(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {


            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

                /**
                 * Called when a drawer has settled in a completely closed state.
                 */
                public void onDrawerClosed(View view) {
                    super.onDrawerClosed(view);
                    getSupportActionBar().setTitle(R.string.main_title);
                    invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                }

                /**
                 * Called when a drawer has settled in a completely open state.
                 */
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    getSupportActionBar().setTitle(R.string.drawer_title);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                }
            };

            drawerToggle.syncState();

            // Set the drawer toggle as the DrawerListener
            mDrawerLayout.addDrawerListener(drawerToggle);
            mDrawerLayout.setScrimColor(Color.TRANSPARENT);
            assert mFab == null;
        }


    }


    @Override
    public void initializeInjector() {
        BaseApplication application = (BaseApplication) getApplication();
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).appComponent(application.getAppComponent()).build();
        mActivityComponent.inject(this);
    }

    @Override
    public void showSnackBarMsg(@StringRes int msg) {
        SnackBarUtils.show(this, msg);
    }
}
