package com.example.myrecyclerview.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myrecyclerview.R;
import com.example.myrecyclerview.model.MainModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "EXTRA_KEY";
    TextView tvName, tvYear, tvDesc;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MainModel dataMain = getIntent().getParcelableExtra(EXTRA_KEY);

        tvName = findViewById(R.id.tv_name);
        tvYear = findViewById(R.id.tv_year);
        tvDesc = findViewById(R.id.tv_desc);
        imgPhoto = findViewById(R.id.img_photo);

        tvName.setText(dataMain.getName());
        tvYear.setText(dataMain.getYear());
        tvDesc.setText(dataMain.getDesc());

        Glide.with(this)
                .load(dataMain.getPhoto())
                .into(imgPhoto);
    }
}
