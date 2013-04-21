package com.mmoscene.h4j.database;

import com.mmoscene.h4j.habbohotel.furniture.Furniture;
import gnu.trove.map.hash.THashMap;

import java.sql.ResultSet;

public interface FurnitureDatabaseObject {

    public THashMap<Integer, Furniture> getFurniture();

    public Furniture generateAndFill(ResultSet set);
}
