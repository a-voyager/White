package top.wuhaojie.white;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import top.wuhaojie.white.adapter.CardsAdapter;
import top.wuhaojie.white.base.BaseActivity;
import top.wuhaojie.white.base.BaseApplication;
import top.wuhaojie.white.entities.impl.MusicItemImpl;
import top.wuhaojie.white.injector.componet.ActivityComponent;
import top.wuhaojie.white.injector.componet.DaggerActivityComponent;
import top.wuhaojie.white.injector.module.ActivityModule;
import top.wuhaojie.white.presenter.impl.MainPresenter;
import top.wuhaojie.white.utils.MusicItemFactory;
import top.wuhaojie.white.utils.SnackBarUtils;
import top.wuhaojie.white.view.IMainView;
import top.wuhaojie.white.view.SwitchView;

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
    @BindView(R.id.rv_main)
    RecyclerView mRvMain;

//    @BindView(R.id.switch_view_card)
//    SwitchView switchViewCard;
//
//    @OnClick(R.id.card_item)
//    void onClick() {
//        switchViewCard.addLevel();
//    }


    private ActivityComponent mActivityComponent;
    private CardsAdapter mAdapter;

    @OnClick(R.id.fab)
    void fabOnclick(View v) {
        mMainPresenter.fabOnclick(v);
    }


    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreateForPresenter(Bundle savedInstanceState) {
        mMainPresenter.onCreate(savedInstanceState);
    }

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

        initDrawer();

        initLeftDrawerList();

        initRecyclerView();

    }

    private void initLeftDrawerList() {
        mLeftDrawer.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, new String[]{"关  于"}));
        mLeftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMainPresenter.onItemClick(parent, view, position, id);
            }
        });
    }

    private void initRecyclerView() {
        mRvMain.setLayoutManager(new GridLayoutManager(this, 3));
        List<MusicItemImpl> iMusicItems = MusicItemFactory.getInstance().getIMusicItems();
        mAdapter = new CardsAdapter(this, iMusicItems, new CardsAdapter.OnCardClickListener() {
            @Override
            public void onClick(String tag, SwitchView view) {
                mMainPresenter.onClick(tag, view);
            }
        });
        mRvMain.setAdapter(mAdapter);
    }

    private void initDrawer() {
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
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMainPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();
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

    @Override
    public void switch2PauseState() {
        mFab.setImageResource(R.drawable.play);
    }

    @Override
    public void switch2PlayState() {
        mFab.setImageResource(R.drawable.pause);
    }

    @Override
    public void addLevel(SwitchView view) {
        view.addLevel();
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }
}
