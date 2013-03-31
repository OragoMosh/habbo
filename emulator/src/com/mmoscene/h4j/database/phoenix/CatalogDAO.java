package com.mmoscene.h4j.database.phoenix;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.database.CatalogDatabaseObject;
import com.mmoscene.h4j.habbohotel.catalog.CatalogItem;
import com.mmoscene.h4j.habbohotel.catalog.CatalogLayout;
import com.mmoscene.h4j.habbohotel.catalog.CatalogPage;
import gnu.trove.map.hash.THashMap;
import org.magicwerk.brownies.collections.GapList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

public class CatalogDAO implements CatalogDatabaseObject {
    @Override
    public LinkedHashMap<Integer, CatalogPage> getParents() {
        LinkedHashMap<Integer, CatalogPage> parents = new LinkedHashMap<>();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM catalog_pages WHERE parent_id = ? ORDER BY `order_num` ASC")) {
                statement.setInt(1, -1);

                try (ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        parents.put(set.getInt("id"), this.generateAndFillPage(set, true));
                    }

                }
            }
        } catch (Exception ex) {
            H4J.getLogger(CatalogDAO.class.getName()).error(ex.getMessage());
        }

        return parents;
    }

    @Override
    public LinkedHashMap<Integer, CatalogPage> getSecondary() {
        LinkedHashMap<Integer, CatalogPage> secondary = new LinkedHashMap<>();

        try (Connection connection = H4J.getStorage().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM catalog_pages WHERE parent_id <> ? ORDER BY `order_num` ASC")) {
                statement.setInt(1, -1);

                try (ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        secondary.put(set.getInt("id"), this.generateAndFillPage(set, false));
                    }

                }
            }
        } catch (Exception ex) {
            H4J.getLogger(CatalogDAO.class.getName()).error(ex.getMessage());
        }

        return secondary;
    }

    @Override
    public THashMap<Integer, CatalogItem> getItems() {
        return null;
    }

    @Override
    public void fill(CatalogPage page, ResultSet set) {
    }

    @Override
    public void fill(CatalogItem item, ResultSet set) {
    }

    @Override
    public CatalogPage generateAndFillPage(ResultSet set, boolean isParent) {
        CatalogPage page = new CatalogPage();

        try {
            page.setId(set.getInt("id"));
            page.setParent(set.getInt("parent_id"));
            page.setOrder(set.getInt("order_num"));
            page.setIconColor(set.getInt("icon_color"));
            page.setIconImage(set.getInt("icon_image"));
            page.setRank(set.getInt("min_rank"));
            page.setLayout(CatalogLayout.valueOf(set.getString("page_layout")));
            page.setTitle(set.getString("caption"));
            page.setHeader(set.getString("page_headline"));
            page.setDescription(set.getString("page_text1"));
            page.setEnabled(set.getInt("enabled") == 1);
        } catch (Exception ignored) {}

        page.setUsingRealData(false);
        page.setHeaders(new GapList<String>());
        page.setTexts(new GapList<String>());
        return page;
    }

    @Override
    public CatalogItem generateAndFillItem(ResultSet set) {
        return null;
    }
}
