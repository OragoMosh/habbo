package com.mmoscene.h4j.database.grizzly;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.database.UserDatabaseObject;
import com.mmoscene.h4j.habbohotel.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO implements UserDatabaseObject {

    @Override
    public void generate(String ticket) {
        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_users WHERE client_key = ?")) {

            }
        } catch (Exception ex) {
            H4J.getLogger(UserDAO.class.getName()).info(ex.getMessage());
        }
    }

    @Override
    public void fill(User user, ResultSet set) {
    }

    @Override
    public User generateAndFillUser(String ticket) {
        User user = new User();

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
                    }
                }
            }
        } catch (Exception ex) {
            H4J.getLogger(UserDAO.class.getName()).info(ex.getMessage());
        }

        return user;
    }

    @Override
    public void append(User user) {
    }
}
