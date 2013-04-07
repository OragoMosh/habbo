package com.mmoscene.h4j.database;

public class DAO {

    private User user_db_obj;
    private Catalog catalog_db_obj;
    private Furniture furniture_db_obj;
    private Messenger messenger_db_obj;

    public DAO() {
        user_db_obj = new User();
        catalog_db_obj = new Catalog();
        furniture_db_obj = new Furniture();
        messenger_db_obj = new Messenger();
    }

    public User getUserDAO() {
        return user_db_obj;
    }

    public Catalog getCatalogDAO() {
        return catalog_db_obj;
    }

    public Furniture getFurnitureDAO() {
        return furniture_db_obj;
    }

    public Messenger getMessengerDAO() {
        return messenger_db_obj;
    }
}
