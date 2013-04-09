package com.mmoscene.h4j.database;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.habbohotel.rooms.Room;
import org.magicwerk.brownies.collections.GapList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Navigator {
    public GapList<Room> getUserRooms(int user) {
        GapList<Room> rooms = new GapList<>();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_rooms WHERE owner = ?")) {
                statement.setInt(1, user);

                try(ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        rooms.add(H4J.getDAO().getRoomDAO().generate(set));
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(Navigator.class.getName()).info(ex.getMessage());
        }

        return rooms;
    }

    public GapList<Room> performSearch(String query) {
        GapList<Room> rooms = new GapList<>();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_rooms WHERE name LIKE ? LIMIT 15")) {
                statement.setString(1, "%" + query + "%");

                try(ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        rooms.add(H4J.getDAO().getRoomDAO().generate(set));
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(Navigator.class.getName()).info(ex.getMessage());
        }

        return rooms;
    }

    public void createRoom(String Name, String Model, int Owner) {
        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO server_rooms (name, model, owner, description) VALUES (?, ?, ?, ?)")) {
                statement.setString(1, Name);
                statement.setString(2, Model);
                statement.setInt(3, Owner);
                statement.setString(4, Name + " - #TeamChromide");

                statement.execute();
            }
        } catch (Exception ex) {
            H4J.getLogger(Navigator.class.getName()).info(ex.getMessage());
        }
    }
}
