package com.mmoscene.h4j.communication.composers.user;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.Response;

public class LoadUserCreditsComposer {
    public static Response compose(int credits) {
        Response response = new Response();

        response.init(H4J.getHeaders().getInt("LoadUserCreditsComposer"));
        response.addString(credits + ".0");

        return response;
    }
}
