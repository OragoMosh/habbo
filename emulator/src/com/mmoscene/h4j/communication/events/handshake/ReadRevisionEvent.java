package com.mmoscene.h4j.communication.events.handshake;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.network.sessions.Session;

public class ReadRevisionEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        H4J.getLogger(ReadRevisionEvent.class.getName()).info(request.readString());
    }
}
