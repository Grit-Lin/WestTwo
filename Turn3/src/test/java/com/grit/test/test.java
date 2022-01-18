package com.grit.test;

import com.grit.dao.locationMapper;
import com.grit.dao.weatherMapper;
import com.grit.utils.MyBatisUtils;
import com.grit.utils.QWeatherUtils;
import org.apache.ibatis.session.SqlSession;

public class test {

    public static void main(String[] args) {
        String key = null;

        try {
            key = "17279746b89745bdbd26a654dea029ed";
            SqlSession sqlSession = MyBatisUtils.getSqlSession();

            locationMapper locationMapper = sqlSession.getMapper(locationMapper.class);
            weatherMapper weatherMapper = sqlSession.getMapper(weatherMapper.class);

            QWeatherUtils.addCity("福州",key,locationMapper);
            QWeatherUtils.addCity("北京",key,locationMapper);
            QWeatherUtils.addCity("上海",key,locationMapper);

            QWeatherUtils.updateWeather("福州",key,locationMapper,weatherMapper);
            QWeatherUtils.updateWeather("北京",key,locationMapper,weatherMapper);
            QWeatherUtils.updateWeather("上海",key,locationMapper,weatherMapper);

            QWeatherUtils.queryWeather("福州",locationMapper,weatherMapper);

            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
