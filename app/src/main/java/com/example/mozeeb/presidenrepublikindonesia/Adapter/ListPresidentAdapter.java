package com.example.mozeeb.presidenrepublikindonesia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mozeeb.presidenrepublikindonesia.DetailsActivity;
import com.example.mozeeb.presidenrepublikindonesia.MainActivity;
import com.example.mozeeb.presidenrepublikindonesia.Model.President;
import com.example.mozeeb.presidenrepublikindonesia.R;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder>{
    private Context context;

    public ListPresidentAdapter(Context context) {
        this.context = context;

    }


    public ArrayList<President> getListPresident() {
        return listPresident;
    }
    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    private ArrayList<President>listPresident;



    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {

        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);


        }
    }
}