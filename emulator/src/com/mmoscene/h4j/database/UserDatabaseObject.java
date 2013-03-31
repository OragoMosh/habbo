package com.mmoscene.h4j.database;

import com.mmoscene.h4j.habbohotel.user.User;

import java.sql.ResultSet;

public interface UserDatabaseObject {

    public void generate(String ticket);

    public void fill(User user, ResultSet set);

    public User generateAndFillUser(String ticket);

    public void append(User user);
}
