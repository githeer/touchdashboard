package org.github.thornfish.touchdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.github.thornfish.arcprogress.ArcProgress;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.arcprogress)
    ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        arcProgress.setCallback(new ArcProgress.Callback() {
            @Override
            public void update(int anglescale) {
                Log.d("ArcProgress", "progress:" + anglescale);
            }
        });
    }

    @OnClick(R.id.button)
    public void button(View view){
        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }

}
