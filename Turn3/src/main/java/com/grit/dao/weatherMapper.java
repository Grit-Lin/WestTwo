package com.grit.dao;

import com.grit.pojo.Daily;

import java.sql.Date;

public interface weatherMapper {
    int addWeather(Daily daily);

    int updateWeather(Daily daily);

    Daily getWeatherByIDAndFxDate(Daily daily);
}
