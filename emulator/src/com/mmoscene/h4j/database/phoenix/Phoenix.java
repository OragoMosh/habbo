package com.mmoscene.h4j.database.phoenix;

import com.mmoscene.h4j.database.CatalogDatabaseObject;
import com.mmoscene.h4j.database.DatabaseObject;
import com.mmoscene.h4j.database.FurnitureDatabaseObject;
import com.mmoscene.h4j.database.UserDatabaseObject;

public class Phoenix implements DatabaseObject {

    private UserDatabaseObject user_db_obj;
    private CatalogDatabaseObject catalog_db_obj;

    public Phoenix() {
        user_db_obj = new UserDAO();
        catalog_db_obj = new CatalogDAO();
    }

    public UserDatabaseObject getUserDAO() {
        return user_db_obj;
    }

    public CatalogDatabaseObject getCatalogDAO() {
        return catalog_db_obj;
    }

    @Override
    public FurnitureDatabaseObject getFurnitureDAO() {
        return null;
    }
}
