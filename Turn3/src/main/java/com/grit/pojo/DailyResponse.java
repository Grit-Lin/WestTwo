package com.grit.pojo;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class DailyResponse {
    private String code;
    private String updateTime;
    private String fxLink;
    private List<Daily> daily;
    private Refer refer;
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }
    public String getFxLink() {
        return fxLink;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
    public List<Daily> getDaily() {
        return daily;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
    public Refer getRefer() {
        return refer;
    }


}
