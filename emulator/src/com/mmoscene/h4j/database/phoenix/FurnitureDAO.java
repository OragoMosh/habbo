package com.mmoscene.h4j.database.phoenix;

import com.mmoscene.h4j.database.FurnitureDatabaseObject;
import com.mmoscene.h4j.habbohotel.furniture.Furniture;
import gnu.trove.map.hash.THashMap;

import java.sql.ResultSet;

public class FurnitureDAO implements FurnitureDatabaseObject {
    @Override
    public THashMap<Integer, Furniture> getFurniture() {
        return null;
    }

    @Override
    public Furniture generateAndFill(ResultSet set) {
        return null;
    }
}
