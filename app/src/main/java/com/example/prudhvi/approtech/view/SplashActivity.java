package com.example.prudhvi.approtech.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prudhvi.approtech.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {

                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, WildAnimalActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
