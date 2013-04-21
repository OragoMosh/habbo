package com.mmoscene.h4j.database.grizzly;

import com.mmoscene.h4j.database.CatalogDatabaseObject;
import com.mmoscene.h4j.database.DatabaseObject;
import com.mmoscene.h4j.database.FurnitureDatabaseObject;
import com.mmoscene.h4j.database.UserDatabaseObject;

public class Grizzly implements DatabaseObject {

    private UserDatabaseObject user_db_obj;
    private CatalogDatabaseObject catalog_db_obj;
    private FurnitureDatabaseObject furniture_db_obj;

    public Grizzly() {
        user_db_obj = new UserDAO();
        catalog_db_obj = new CatalogDAO();
        furniture_db_obj = new FurnitureDAO();
    }

    public UserDatabaseObject getUserDAO() {
        return user_db_obj;
    }

    public CatalogDatabaseObject getCatalogDAO() {
        return catalog_db_obj;
    }

    @Override
    public FurnitureDatabaseObject getFurnitureDAO() {
        return furniture_db_obj;
    }


    public String getCatalogParents() {
        return "SELECT * FROM server_store_parents ORDER BY `order` ASC";
    }
}
