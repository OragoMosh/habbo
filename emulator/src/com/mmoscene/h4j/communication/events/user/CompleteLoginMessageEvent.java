package com.mmoscene.h4j.communication.events.user;

import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.user.SendUserFuseRankMessageComposer;
import com.mmoscene.h4j.network.sessions.Session;

public class CompleteLoginMessageEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        session.respond(SendUserFuseRankMessageComposer.compose(session.getHabbo().getRank()));
    }
}
