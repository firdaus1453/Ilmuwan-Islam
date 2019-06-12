package com.example.myrecyclerview.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myrecyclerview.R;
import com.example.myrecyclerview.model.MainData;
import com.example.myrecyclerview.model.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private ArrayList<MainModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_main);
        rvMain.setHasFixedSize(true);

        list.addAll(MainData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ListMainAdapter listMainAdapter = new ListMainAdapter(this);
        listMainAdapter.setListMain(list);
        rvMain.setAdapter(listMainAdapter);
    }
}
