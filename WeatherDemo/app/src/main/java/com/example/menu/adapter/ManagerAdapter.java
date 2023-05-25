package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.CityManagerItem;
import com.example.menu.item.SearchListItem;

import java.util.List;

public class ManagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<CityManagerItem> cityData;

    public ManagerAdapter(Context context, List<CityManagerItem> cityData) {
        this.context = context;
        this.cityData = cityData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchCityAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.city_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int id) {
        SearchCityAdapter.ItemViewHolder itemViewHolder = (SearchCityAdapter.ItemViewHolder) holder;
        itemViewHolder.searchCityText.setText(cityData.get(id).getCityName());
    }

    @Override
    public int getItemCount() {
        return cityData.size();
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
        }
    }
}
