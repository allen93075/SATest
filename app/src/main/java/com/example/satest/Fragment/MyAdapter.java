package com.example.satest.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.satest.R;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ItemData[] itemsData;
    public MyAdapter(ItemData[] ItemData){
        this.itemsData = ItemData;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.begin_search, null);
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.textView.setText(itemsData[position].getUrl());
        Picasso.get().load(itemsData[position].itemGetUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ViewHolder(View image_View) {
            super(image_View);
            imageView = image_View.findViewById(R.id.imageView);
            //imageView = searchView.findViewById(R.id.imageView);
        }
    }
}