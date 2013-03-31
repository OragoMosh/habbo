package com.mmoscene.h4j.database;

public interface DatabaseObject {

    public UserDatabaseObject getUserDAO();
    public CatalogDatabaseObject getCatalogDAO();
    public FurnitureDatabaseObject getFurnitureDAO();

}
