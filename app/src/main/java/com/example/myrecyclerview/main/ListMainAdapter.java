package com.example.myrecyclerview.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myrecyclerview.R;
import com.example.myrecyclerview.model.MainModel;

import java.util.ArrayList;

public class ListMainAdapter extends RecyclerView.Adapter<ListMainAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MainModel> listMain;

    public ArrayList<MainModel> getListMain() {
        return listMain;
    }

    public void setListMain(ArrayList<MainModel> listMain) {
        this.listMain = listMain;
    }

    public ListMainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_main, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(getListMain().get(i).getName());
        viewHolder.tvYear.setText(getListMain().get(i).getYear());
        viewHolder.tvDesc.setText(getListMain().get(i).getDesc());

        Glide.with(context)
                .load(getListMain().get(i).getPhoto())
                .into(viewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listMain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvYear, tvDesc;
        ImageView imgPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvYear = itemView.findViewById(R.id.tv_year);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.img_photo);

        }
    }
}
