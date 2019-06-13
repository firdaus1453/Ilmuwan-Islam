package com.example.myrecyclerview.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myrecyclerview.R;
import com.example.myrecyclerview.detail.DetailActivity;
import com.example.myrecyclerview.model.MainData;
import com.example.myrecyclerview.model.MainModel;
import com.example.myrecyclerview.support.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private SearchView srcView;
    private TextView titleMain, txtFooter;
    private ArrayList<MainModel> list = new ArrayList<>();
    Animation btt,ttb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srcView = findViewById(R.id.searchView);
        titleMain = findViewById(R.id.txt_main);
        txtFooter = findViewById(R.id.txt_footer);
        rvMain = findViewById(R.id.rv_main);
        rvMain.setHasFixedSize(true);

        list.addAll(MainData.getListData());
        showRecyclerList();

        // load animation
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        // run anim
        srcView.startAnimation(ttb);
        titleMain.startAnimation(ttb);
        rvMain.startAnimation(btt);
        txtFooter.startAnimation(btt);


    }

    private void showRecyclerList() {
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvMain);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvMain.setLayoutManager(linearLayoutManager);
        ListMainAdapter listMainAdapter = new ListMainAdapter(this);
        listMainAdapter.setListMain(list);
        rvMain.setAdapter(listMainAdapter);

        ItemClickSupport.addTo(rvMain).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // Menyimpan data ke dalam model
                MainModel mainModel = new MainModel();
                mainModel.setName(list.get(position).getName());
                mainModel.setYear(list.get(position).getYear());
                mainModel.setDesc(list.get(position).getDesc());
                mainModel.setPhoto(list.get(position).getPhoto());

                // Berpindah halaman dengan membawa data yang sudah disimpan di dalam model
                startActivity(new Intent(MainActivity.this, DetailActivity.class).putExtra(DetailActivity.EXTRA_KEY,mainModel));
            }
        });
    }
}
