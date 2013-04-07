package com.mmoscene.h4j.communication.events.messenger;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.messenger.SendInstantMessageComposer;
import com.mmoscene.h4j.network.sessions.Session;

public class SendInstantMessageEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        int user = request.readInt();
        String message = request.readString();

        if (H4J.getNetwork().getSessionManager().getOnlineStatusById(user)) {
           Session friend = H4J.getNetwork().getSessionManager().getSessionById(user);

            friend.respond(SendInstantMessageComposer.compose(session.getHabbo().getId(), message));
        } else {
            session.respond(SendInstantMessageComposer.compose(user, "Your friend is offline!"));
        }
    }
}
