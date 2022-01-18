package com.grit.pojo;

import java.util.List;

public class LocationResponse {
        private Integer code;
        private List<Location> location;
        private Refer refer;




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    @Override
    public String toString() {
        return "LocationResponse{" +
                "code=" + code +
                ", location=" + location +
                ", refer=" + refer +
                '}';
    }
}
