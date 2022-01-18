package com.grit.utils;

import com.alibaba.fastjson.JSON;
import com.grit.dao.locationMapper;
import com.grit.dao.weatherMapper;
import com.grit.pojo.Daily;
import com.grit.pojo.DailyResponse;
import com.grit.pojo.Location;
import com.grit.pojo.LocationResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QWeatherUtils {

    //添加城市信息到数据库
    public static void addCity(String cityName, String key, locationMapper mapper) throws UnsupportedEncodingException {

        StringBuilder res = HttpUtils.sendGet("https://geoapi.qweather.com/v2/city/lookup", "key=" + key + "&location=" + URLEncoder.encode(cityName, "utf-8") + "&number=1");
            LocationResponse locationResponse = JSON.parseObject(String.valueOf(res), LocationResponse.class);
            for(Location location : locationResponse.getLocation()){
                if(mapper.getLocationByName(location.getName()) == null){
                    mapper.addLocation(location);
                }
            }
        }

    //添加天气信息到数据库
    public static void updateWeather(String cityName, String key,locationMapper locationMapper, weatherMapper weatherMapper){
        Location city = locationMapper.getLocationByName(cityName);
        if(city == null) throw new RuntimeException(cityName + "不存在于数据库中");
        int cityID = city.getId();
        StringBuilder res = HttpUtils.sendGet("https://devapi.qweather.com/v7/weather/3d", "key=" + key + "&location=" + cityID);
        DailyResponse dailyResponse = JSON.parseObject(String.valueOf(res), DailyResponse.class);
        for(Daily daily : dailyResponse.getDaily()){
            //判断日期和所属城市ID，如果数据库中已经存在则更新数据，如果不存在则插入数据
            daily.setId(cityID);
            if(weatherMapper.getWeatherByIDAndFxDate(daily) == null){
                weatherMapper.addWeather(daily);
                continue;
            }
            weatherMapper.updateWeather(daily);
        }
    }

    //返回城市今明后三天的天气信息
    public static void queryWeather(String cityName,locationMapper locationMapper, weatherMapper weatherMapper){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar cal= Calendar.getInstance();
        Location city = locationMapper.getLocationByName(cityName);
        int id = city.getId();
        for(int i = 0 ;i < 3;i++){
            Daily daily = new Daily();
            daily.setId(id);
            cal.add(Calendar.DAY_OF_MONTH,+i);
            date = cal.getTime();
            daily.setFxDate(df.format(date));
            Daily weatherByIDAndFxDate = weatherMapper.getWeatherByIDAndFxDate(daily);
            System.out.println(weatherByIDAndFxDate);
        }
    }



    }

