package com.mmoscene.h4j.habbohotel;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.habbohotel.catalog.CatalogManager;
import com.mmoscene.h4j.habbohotel.furniture.FurnitureManager;

public class HabboHotel {

    private CatalogManager catalog_manager;
    private FurnitureManager furniture_manager;

    public HabboHotel() {
        catalog_manager = new CatalogManager();
        furniture_manager = new FurnitureManager();

        H4J.getLogger(HabboHotel.class.getName()).info("Loaded Habbo Hotel successfully!");
    }

    public CatalogManager getCatalogManager() {
        return catalog_manager;
    }

    public FurnitureManager getFurnitureManager() {
        return furniture_manager;
    }
}
