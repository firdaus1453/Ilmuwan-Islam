package com.example.myrecyclerview.intro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myrecyclerview.R;
import com.example.myrecyclerview.main.MainActivity;

public class IntroActivity extends AppCompatActivity {

    Animation btt,ttb;
    Button btnStart;
    TextView txtIntro;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnStart = findViewById(R.id.btn_start);
        txtIntro = findViewById(R.id.txt_intro);
        imgLogo = findViewById(R.id.img_logo);

        // load animation
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        // run animation
        btnStart.startAnimation(btt);
        imgLogo.startAnimation(ttb);
        txtIntro.startAnimation(ttb);

    }

    public void start(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
