package com.mmoscene.h4j.database;

import com.mmoscene.h4j.habbohotel.catalog.CatalogItem;
import com.mmoscene.h4j.habbohotel.catalog.CatalogPage;
import gnu.trove.map.hash.THashMap;

import java.sql.ResultSet;
import java.util.LinkedHashMap;

public interface CatalogDatabaseObject {

    public LinkedHashMap<Integer, CatalogPage> getParents();
    public LinkedHashMap<Integer, CatalogPage> getSecondary();

    public THashMap<Integer, CatalogItem> getItems();

    public void fill(CatalogPage page, ResultSet set);
    public void fill(CatalogItem item, ResultSet set);

    public CatalogPage generateAndFillPage(ResultSet set, boolean isParent);
    public CatalogItem generateAndFillItem(ResultSet set);
}
