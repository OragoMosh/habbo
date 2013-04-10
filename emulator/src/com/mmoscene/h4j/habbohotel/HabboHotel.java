package com.mmoscene.h4j.habbohotel;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.habbohotel.cache.CacheTask;
import com.mmoscene.h4j.habbohotel.catalog.CatalogManager;
import com.mmoscene.h4j.habbohotel.furniture.FurnitureManager;
import com.mmoscene.h4j.habbohotel.hotelview.PromoPiece;
import org.magicwerk.brownies.collections.GapList;

public class HabboHotel {

    private CatalogManager catalog_manager;
    private FurnitureManager furniture_manager;

    private GapList<PromoPiece> promos = new GapList<>();

    private CacheTask task;

    public HabboHotel() {
        catalog_manager = new CatalogManager();
        furniture_manager = new FurnitureManager();

        promos = H4J.getDAO().getHotelViewDAO().getPromos();

        task = new CacheTask();

        H4J.getLogger(HabboHotel.class.getName()).info("Loaded Habbo Hotel successfully!");
    }

    public CatalogManager getCatalogManager() {
        return catalog_manager;
    }

    public FurnitureManager getFurnitureManager() {
        return furniture_manager;
    }

    public GapList<PromoPiece> getPromos() {
        return promos;
    }

    public CacheTask getCacheTask() {
        return task;
    }

    public void reloadPromos() {
        promos = H4J.getDAO().getHotelViewDAO().getPromos();
    }
}
