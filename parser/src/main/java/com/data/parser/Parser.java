package com.data.parser;

import com.data.parser.model.InfoEvent;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Parser {
    private final String URL = "https://line12.bkfon-resources.com/live/currentLine/ru?scopeMarket=1600&sysId=1";

    public InfoEvent parse() {
        Content postResult = null;
        try {
            postResult = Request.Get(URL)
                    .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        InfoEvent infoEvent = null;
        if (postResult != null) {
            infoEvent = gson.fromJson(postResult.asString(), InfoEvent.class);
        }
        return infoEvent;
    }
}
