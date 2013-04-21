package com.mmoscene.h4j.communication.composers.user;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.Response;

public class LoadUserCurrencyComposer {
    public static Response compose(int duckets) {
        Response response = new Response();

        response.init(H4J.getHeaders().getInt("LoadUserCurrencyComposer"));

        response.addInt(1);
        response.addInt(0);
        response.addInt(duckets);

        return response;
    }
}
