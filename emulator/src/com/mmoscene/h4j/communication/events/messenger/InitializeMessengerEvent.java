package com.mmoscene.h4j.communication.events.messenger;

import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.messenger.InitializeMessengerComposer;
import com.mmoscene.h4j.communication.composers.messenger.SendPendingFriendRequestsComposer;
import com.mmoscene.h4j.network.sessions.Session;

public class InitializeMessengerEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        session.respond(InitializeMessengerComposer.compose(session.getHabbo().getMessenger().getFriends()));
        session.respond(SendPendingFriendRequestsComposer.compose(session.getHabbo().getMessenger().getRequests()));
        session.getHabbo().getMessenger().setUpdate(true);
    }
}
