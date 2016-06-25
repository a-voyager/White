package top.wuhaojie.white.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import top.wuhaojie.white.R;
import top.wuhaojie.white.injector.interfaces.IConfigInjector;

/**
 * Created by wuhaojie on 2016/6/22 19:45.
 */
public abstract class BaseActivity extends AppCompatActivity implements IAppView, IConfigInjector {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews(savedInstanceState);
        initializeInjector();
        initPresenter();
    }

    protected abstract void initPresenter();

    public abstract int getLayoutResID();

    public abstract void initViews(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
