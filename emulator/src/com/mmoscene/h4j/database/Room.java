package com.mmoscene.h4j.database;

import com.mmoscene.h4j.H4J;

import java.sql.ResultSet;

public class Room {
    public com.mmoscene.h4j.habbohotel.rooms.Room generate(ResultSet set) {
        com.mmoscene.h4j.habbohotel.rooms.Room room = new com.mmoscene.h4j.habbohotel.rooms.Room();

        try {
            room.setId(set.getInt("id"));
            room.setOwner(set.getInt("owner"));
            room.setState(set.getInt("state"));
            room.setGuild(set.getInt("guild"));

            room.setName(set.getString("name"));
            room.setDescription(set.getString("description"));
            room.setPassword(set.getString("password"));
            room.setModel(set.getString("model"));
            room.setWallpaper(set.getString("wallpaper"));
            room.setFloor(set.getString("floor"));
            room.setLandscape(set.getString("landscape"));
        } catch (Exception ex) {
            H4J.getLogger(Room.class.getName()).info(ex.getMessage());
        }

        return room;
    }
}
