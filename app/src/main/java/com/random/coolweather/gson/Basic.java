package com.random.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 天气Basic JavaBean
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;
    }
}
