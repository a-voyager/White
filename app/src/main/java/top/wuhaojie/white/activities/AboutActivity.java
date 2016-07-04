package top.wuhaojie.white.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import top.wuhaojie.white.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        overridePendingTransition(R.anim.activity_down_up_anim, R.anim.activity_up_down_anim);
    }
}
