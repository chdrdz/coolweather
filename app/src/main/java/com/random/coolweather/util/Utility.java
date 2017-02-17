package com.random.coolweather.util;

import android.text.TextUtils;

import com.random.coolweather.db.City;
import com.random.coolweather.db.County;
import com.random.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 处理服务器返回的Json数据
 */

public class Utility {

    /**
     * 存储服务器返回的省级数据
     *
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();//数据库增加数据
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 处理市级返回数据
     *
     * @param response
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();//数据库增加数据
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理县级数据
     *
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allcounties = new JSONArray(response);
                for (int i = 0; i < allcounties.length(); i++) {
                    JSONObject countyObject = allcounties.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherID(countyObject.getString("weather_id"));
                    county.save();//存储数据到数据库
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
