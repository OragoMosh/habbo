package com.mmoscene.h4j.database;

import com.mmoscene.h4j.H4J;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    public void generate(String ticket) {
        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_users WHERE client_key = ?")) {

            }
        } catch (Exception ex) {
            H4J.getLogger(User.class.getName()).info(ex.getMessage());
        }
    }

    public com.mmoscene.h4j.habbohotel.user.User getUserBySSO(String ticket) {
        com.mmoscene.h4j.habbohotel.user.User user = new com.mmoscene.h4j.habbohotel.user.User();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_users WHERE client_key = ?")) {
                statement.setString(1, ticket);

                try (ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        user.setId(set.getInt("id"));
                        user.setCredits(set.getInt("credits"));
                        user.setPixels(set.getInt("pixels"));
                        user.setCurrency(set.getInt("currency"));
                        user.setRank(set.getInt("rank"));
                        user.setRespect(set.getInt("respect_points"));
                        user.setDailyRespect(set.getInt("daily_respect"));
                        user.setNameChanges(set.getInt("active_name_changes"));
                        user.setPrimaryGuild(set.getInt("primary_guild"));

                        user.setUsername(set.getString("username"));
                        user.setEmail(set.getString("email"));
                        user.setMotto(set.getString("motto"));
                        user.setLook(set.getString("look"));
                        user.setLastActive(set.getString("last_active"));

                        user.setGender(set.getString("gender").charAt(0));

                        user.startMessenger();
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(User.class.getName()).info(ex.getMessage());
        }

        return user;
    }

    public com.mmoscene.h4j.habbohotel.user.User getUserById(int id) {
        com.mmoscene.h4j.habbohotel.user.User user = new com.mmoscene.h4j.habbohotel.user.User();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_users WHERE id = ?")) {
                statement.setInt(1, id);

                try (ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        user.setId(set.getInt("id"));
                        user.setCredits(set.getInt("credits"));
                        user.setPixels(set.getInt("pixels"));
                        user.setCurrency(set.getInt("currency"));
                        user.setRank(set.getInt("rank"));
                        user.setRespect(set.getInt("respect_points"));
                        user.setDailyRespect(set.getInt("daily_respect"));
                        user.setNameChanges(set.getInt("active_name_changes"));
                        user.setPrimaryGuild(set.getInt("primary_guild"));

                        user.setUsername(set.getString("username"));
                        user.setEmail(set.getString("email"));
                        user.setMotto(set.getString("motto"));
                        user.setLook(set.getString("look"));
                        user.setLastActive(set.getString("last_active"));

                        user.setGender(set.getString("gender").charAt(0));

                        user.startMessenger();
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(User.class.getName()).info(ex.getMessage());
        }

        return user;
    }

    public int getIdByUsername(String username) {
        int id = 0;

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT id FROM server_users WHERE username = ?")) {
                statement.setString(1, username);

                try(ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        id = set.getInt("id");
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(User.class.getName()).info(ex.getMessage());
        }

        return id;
    }

    public String getUsernameById(int id) {
        String username = "";

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT username FROM server_users WHERE id = ?")) {
                statement.setInt(1, id);

                try(ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        username = set.getString("username");
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(User.class.getName()).info(ex.getMessage());
        }

        return username;
    }

    public void append(com.mmoscene.h4j.habbohotel.user.User user) {
    }
}
