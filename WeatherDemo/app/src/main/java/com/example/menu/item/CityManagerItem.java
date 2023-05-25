package com.example.menu.item;

public class CityManagerItem {
    private String cityName;
//    private String temperature;

//    public String getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(String temperature) {
//        this.temperature = temperature;
//    }


    public CityManagerItem(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
