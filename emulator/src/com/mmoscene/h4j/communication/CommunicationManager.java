package com.mmoscene.h4j.communication;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.events.catalog.LoadCatalogIndexEvent;
import com.mmoscene.h4j.communication.events.catalog.LoadCatalogPageEvent;
import com.mmoscene.h4j.communication.events.handshake.*;
import com.mmoscene.h4j.communication.events.user.LoadUserClubEvent;
import com.mmoscene.h4j.communication.events.user.LoadUserInformationEvent;
import com.mmoscene.h4j.network.sessions.Session;
import gnu.trove.map.hash.THashMap;

public class CommunicationManager {
    THashMap<Integer, GameEvent> events = new THashMap<>();

    public CommunicationManager() {
        //events.put(new Integer(), new ());
        this.bindHandshake();
        this.bindUser();
        this.bindCatalog();

        H4J.getLogger(CommunicationManager.class.getName()).info("Binded " + events.size() + " events to their classes!");
    }

    private void bindHandshake() {
        events.put(H4J.getHeaders().getInt("ReadRevisionEvent"), new ReadRevisionEvent());
        events.put(H4J.getHeaders().getInt("InitializeCryptologyEvent"), new InitializeCryptologyEvent());
        events.put(H4J.getHeaders().getInt("SendSecretKeyEvent"), new SendSecretKeyEvent());
        events.put(H4J.getHeaders().getInt("SendUserTicketEvent"), new SendUserTicketEvent());
    }

    private void bindUser() {
        events.put(H4J.getHeaders().getInt("LoadUserInformationEvent"), new LoadUserInformationEvent());
        events.put(H4J.getHeaders().getInt("LoadUserClubEvent"), new LoadUserClubEvent());
    }

    private void bindCatalog() {
        events.put(H4J.getHeaders().getInt("LoadCatalogIndexEvent"), new LoadCatalogIndexEvent());
        events.put(H4J.getHeaders().getInt("LoadCatalogPageEvent"), new LoadCatalogPageEvent());
    }

    public void parse(Session session, Request request) {
        if (!events.containsKey(request.readHeader())) {
            H4J.getLogger(CommunicationManager.class.getName()).warn("[#" + request.readHeader() + "] " + request.body());
        } else {

            GameEvent event = events.get(request.readHeader());

            H4J.getLogger(event.getClass().getName()).info("[" + event.getClass().getSimpleName() + "] " + request.body());

            event.parse(session, request);
        }
    }
}
