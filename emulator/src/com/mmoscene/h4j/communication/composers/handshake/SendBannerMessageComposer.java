package com.mmoscene.h4j.communication.composers.handshake;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.Response;

public class SendBannerMessageComposer {

    public static Response compose() {
        Response response = new Response();

        response.init(new Integer(H4J.getHeaders().get("SendBannerMessageComposer")));
        response.addString("12f449917de4f94a8c48dbadd92b6276");
        response.addBool(false);

        return response;
    }
}
