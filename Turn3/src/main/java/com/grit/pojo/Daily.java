package com.grit.pojo;


import java.util.Date;

public class Daily {
    private int dailyID;
    private String fxDate;
    private int tempMax;
    private int tempMin;
    private String textDay;
    private int id;

    public Daily() {
    }

    public Daily(String fxDate, int tempMax, int tempMin, String textDay, int id) {
        this.fxDate = fxDate;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
        this.id = id;
    }

    public int getDailyID() {
        return dailyID;
    }

    public void setDailyID(int dailyID) {
        this.dailyID = dailyID;
    }

    public String getFxDate() {
        return fxDate;
    }

    public void setFxDate(String fxDate) {
        this.fxDate = fxDate;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "dailyID=" + dailyID +
                ", fxDate='" + fxDate + '\'' +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", textDay='" + textDay + '\'' +
                ", id=" + id +
                '}';
    }
}

