package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.menu.R;
import com.example.menu.dto.CityDTO;
import com.example.menu.item.CityManagerItem;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<CityManagerItem> cityManagerData;

    public CityAdapter(Context context, List<CityManagerItem> cityManagerData) {
        this.context = context;
        this.cityManagerData = cityManagerData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.city_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int id) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        //get(0)是搜省获区第一个城，搜城获取第一个区。还要改

        itemViewHolder.cityName.setText(cityManagerData.get(id).getCityName());
        //气温来自另一个接口
//        itemViewHolder.temperature.setText(cityData.get(position).);
    }

    @Override
    public int getItemCount() {
        return cityManagerData.size();
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView temperature;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cityName = itemView.findViewById(R.id.city_name);
            this.temperature = itemView.findViewById(R.id.temperature);
        }
    }
}
