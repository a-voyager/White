package top.wuhaojie.white;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

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
    @BindView(R.id.left_drawer)
    ListView mLeftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

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
            mDrawerLayout.setDrawerListener(drawerToggle);
            mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        }
    }


}
