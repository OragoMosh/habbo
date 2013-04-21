package com.mmoscene.h4j.database.phoenix;

import com.mmoscene.h4j.database.UserDatabaseObject;
import com.mmoscene.h4j.habbohotel.user.User;

import java.sql.ResultSet;

public class UserDAO implements UserDatabaseObject {
    @Override
    public void generate(String ticket) {
    }

    @Override
    public void fill(User user, ResultSet set) {
    }

    @Override
    public User generateAndFillUser(String ticket) {
        return null;
    }

    @Override
    public void append(User user) {
    }
}
