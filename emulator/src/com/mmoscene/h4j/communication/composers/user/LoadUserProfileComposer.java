package com.mmoscene.h4j.communication.composers.user;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.Response;
import com.mmoscene.h4j.habbohotel.user.User;

public class LoadUserProfileComposer {
    public static Response compose(User user, boolean friends) {
        Response response = new Response();

        response.init(H4J.getHeaders().getInt("LoadUserProfileComposer"));

        response.addInt(user.getId());
        response.addString(user.getUsername());
        response.addString(user.getLook());
        response.addString(user.getMotto());
        response.addString(user.getLastActive());
        response.addInt(0);
        response.addInt(user.getMessenger().getFriends().size());
        response.addBool(friends);
        response.addBool(false);
        response.addBool(H4J.getNetwork().getSessionManager().getOnlineStatusById(user.getId()));         // ?
        response.addInt(0); //guild count
        response.addInt(0);
        response.addBool(true); // enable profile

        return response;
    }
}
