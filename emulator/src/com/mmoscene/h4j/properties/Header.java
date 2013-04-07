package com.mmoscene.h4j.properties;

import com.mmoscene.h4j.H4J;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class Header {

    private Properties prop;

    public Header() {
        prop = new Properties();
    }

    public void load() {
        try {
            URL url = new URL("http://dl.dropbox.com/u/25740521/rY2XMvpj3UabQ3EXBqbP.habbo4java");

            URLConnection connection = url.openConnection();

            prop.load(connection.getInputStream());

            H4J.getLogger(Config.class.getName()).info("Live Headers loaded successfully!");
        } catch(Exception ignored) {
            ignored.printStackTrace();
            H4J.getLogger(Config.class.getName()).error("Cannot access live headers!");
            System.exit(0);
        }
    }

    public String get(String key) {
        return prop.getProperty(key).trim();
    }

    public int getInt(String key) {
        return new Integer(prop.getProperty(key).trim());
    }

    public int size() {
        return prop.size();
    }
}
