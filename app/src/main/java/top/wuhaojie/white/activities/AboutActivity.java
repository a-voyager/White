package top.wuhaojie.white.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import top.wuhaojie.white.R;
import top.wuhaojie.white.base.BaseActivity;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.open_network)
    Button mOpenNetwork;

    @Override
    protected void onCreateForPresenter(Bundle savedInstanceState) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_about;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initializeInjector() {

    }


    @OnClick(R.id.open_network)
    public void onClick() {
        // https://github.com/a-voyager/White
        Uri uri = Uri.parse("https://github.com/a-voyager/White");

        Intent it = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(it);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
