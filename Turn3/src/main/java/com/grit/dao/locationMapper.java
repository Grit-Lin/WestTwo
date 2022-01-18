package com.grit.dao;

import com.grit.pojo.Location;

public interface locationMapper {
    int addLocation(Location location);

    int deleteLocationByID(int id);

    int updateLocation(Location location);

    Location getLocationByName(String name);
}
