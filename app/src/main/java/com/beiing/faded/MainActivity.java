package com.beiing.faded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FadedView fadedView = (FadedView) findViewById(R.id.fadedview);
        fadedView.showWithAnimation(2000);

        FadedFillView fadedFillView = (FadedFillView) findViewById(R.id.fadedfillview);
        fadedFillView.showWithAnimation(3000);
    }
}
