package com.example.myrecyclerview.intro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myrecyclerview.R;
import com.example.myrecyclerview.main.MainActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void start(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
