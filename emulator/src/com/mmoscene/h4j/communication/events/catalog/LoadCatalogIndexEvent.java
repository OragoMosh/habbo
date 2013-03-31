package com.mmoscene.h4j.communication.events.catalog;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.catalog.LoadCatalogIndexComposer;
import com.mmoscene.h4j.network.sessions.Session;

public class LoadCatalogIndexEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        session.respond(LoadCatalogIndexComposer.compose(
                H4J.getHabboHotel().getCatalogManager().getParentsForRank(session.getHabbo().getRank())
        ));
    }
}
