package com.mmoscene.h4j.communication;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.events.catalog.*;
import com.mmoscene.h4j.communication.events.handshake.*;
import com.mmoscene.h4j.communication.events.messenger.*;
import com.mmoscene.h4j.communication.events.user.*;
import com.mmoscene.h4j.network.sessions.Session;
import gnu.trove.map.hash.THashMap;

public class CommunicationManager {
    THashMap<Integer, GameEvent> events = new THashMap<>();

    public CommunicationManager() {
        this.bindHandshake();
        this.bindUser();
        this.bindCatalog();
        this.bindMessenger();

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
        events.put(H4J.getHeaders().getInt("LoadUserProfileEvent"), new LoadUserProfileEvent());
    }

    private void bindCatalog() {
        events.put(H4J.getHeaders().getInt("LoadCatalogIndexEvent"), new LoadCatalogIndexEvent());
        events.put(H4J.getHeaders().getInt("LoadCatalogPageEvent"), new LoadCatalogPageEvent());
    }

    private void bindMessenger() {
        events.put(H4J.getHeaders().getInt("InitializeMessengerEvent"), new InitializeMessengerEvent());
        events.put(H4J.getHeaders().getInt("SendMessengerSearchEvent"), new SendMessengerSearchEvent());
        events.put(H4J.getHeaders().getInt("SendFriendRequestEvent"), new SendFriendRequestEvent());
        events.put(H4J.getHeaders().getInt("AcceptFriendRequestEvent"), new AcceptFriendRequestEvent());
        events.put(H4J.getHeaders().getInt("UpdateFriendStateEvent"), new UpdateFriendStateEvent());
        events.put(H4J.getHeaders().getInt("SendInstantMessageEvent"), new SendInstantMessageEvent());
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
