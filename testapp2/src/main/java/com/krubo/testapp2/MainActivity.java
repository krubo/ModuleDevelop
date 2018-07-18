package com.krubo.testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.krubo.router.RouterManager;
import com.krubo.testapp1.TestApp1Sdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestApp1Sdk.init();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance().startActivity(MainActivity.this, TestApp1Sdk.ACTION, null);
            }
        });
    }
}
