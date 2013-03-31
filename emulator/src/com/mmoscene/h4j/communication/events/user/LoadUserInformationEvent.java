package com.mmoscene.h4j.communication.events.user;

import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.user.LoadUserClubComposer;
import com.mmoscene.h4j.communication.composers.user.LoadUserCreditsComposer;
import com.mmoscene.h4j.communication.composers.user.LoadUserCurrencyComposer;
import com.mmoscene.h4j.communication.composers.user.LoadUserInformationComposer;
import com.mmoscene.h4j.network.sessions.Session;

public class LoadUserInformationEvent implements GameEvent {

    @Override
    public void parse(Session session, Request request) {
        session.respond(LoadUserCreditsComposer.compose(session.getHabbo().getCredits()));
        session.respond(LoadUserCurrencyComposer.compose(session.getHabbo().getPixels()));
        session.respond(LoadUserInformationComposer.compose(session));
    }
}
