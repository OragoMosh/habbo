package com.mmoscene.h4j.database;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.habbohotel.hotelview.PromoPiece;
import org.magicwerk.brownies.collections.GapList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HotelView {
    public GapList<PromoPiece> getPromos() {
        GapList<PromoPiece> promos = new GapList<>();

        try(Connection connection = H4J.getStorage().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM server_articles")) {
                try(ResultSet set = statement.executeQuery()) {
                    while(set.next()) {
                        PromoPiece p = new PromoPiece();

                        p.setId(set.getInt("id"));
                        p.setName(set.getString("name"));
                        p.setStory(set.getString("story"));
                        p.setButtonText(set.getString("button_text"));
                        p.setExternalURL(set.getString("url"));
                        p.setImage(set.getString("image"));

                        promos.add(p);
                    }
                }
            }
        } catch(Exception ex) {
            H4J.getLogger(HotelView.class.getName()).info(ex.getMessage());
        }
        return promos;
    }
}
