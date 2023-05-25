package com.example.menu;



import static com.example.menu.Constant.KEY;
import static com.example.menu.Constant.URL_CITY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.menu.adapter.CityManagerAdapter;
import com.example.menu.databinding.ActivityCityBinding;
import com.example.menu.dto.CityDTO;
import com.example.menu.item.CityManagerItem;
import com.example.menu.item.SearchListItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CityActivity extends AppCompatActivity {
    ActivityCityBinding binding;
    RecyclerView cityManagerRecycler;
    List<CityManagerItem> cityMangerData;
    CityManagerAdapter cityManagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = binding.edit.getText().toString();
                searchCity(location);
            }
        });

        cityManagerRecycler = binding.cityRecycler;
        cityMangerData = new ArrayList<>();
        cityManagerAdapter = new CityManagerAdapter(this,cityMangerData);
        cityManagerRecycler.setAdapter(cityManagerAdapter);
        cityManagerRecycler.setLayoutManager(new LinearLayoutManager(this));


    }

    public void searchCity(String location){
        final String TAG = "searchCity";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request  request = new Request.Builder().url(URL_CITY + location + KEY).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG,"网络请求失败");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if(response.isSuccessful()){
                    Log.d(TAG,"请求接口成功");
                    String str = response.body().string();
                    Gson gson = new Gson();
                    CityDTO cityDTO = gson.fromJson(str,CityDTO.class);

                    if (cityDTO.getCode().equals("200")){
                        Log.d(TAG,"查询成功" + "code=" + cityDTO.getCode());
                        System.out.println(str);

                        for (int i = 0; i < cityDTO.getLocation().size(); i++) {
                            String name = cityDTO.getLocation().get(i).getName();
                            String cityId = cityDTO.getLocation().get(i).getId();
                            System.out.println(i + name + cityId);
                            runOnUiThread(()-> cityMangerData.add(new CityManagerItem(name)));
                        }

                    }else {
                        Log.d(TAG,"请正确输入城市或区" + "code=" + cityDTO.getCode());
                    }
                }

            }
        });
    }
}
