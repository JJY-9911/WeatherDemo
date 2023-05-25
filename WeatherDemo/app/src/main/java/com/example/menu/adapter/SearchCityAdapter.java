package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.SearchListItem;

import java.util.List;

public class SearchCityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SearchListItem> cityListData;

    public SearchCityAdapter(Context context, List<SearchListItem> cityListData) {
        this.context = context;
        this.cityListData = cityListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int id) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.searchCityText.setText(cityListData.get(id).getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView searchCityText;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.searchCityText = itemView.findViewById(R.id.search_city_text);
        }
    }
}
