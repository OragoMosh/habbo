package com.mmoscene.h4j;

import com.mmoscene.h4j.communication.CommunicationManager;
import com.mmoscene.h4j.database.DatabaseObject;
import com.mmoscene.h4j.database.grizzly.Grizzly;
import com.mmoscene.h4j.database.phoenix.Phoenix;
import com.mmoscene.h4j.habbohotel.HabboHotel;
import com.mmoscene.h4j.miscellaneous.Version;
import com.mmoscene.h4j.network.Network;
import com.mmoscene.h4j.properties.Config;
import com.mmoscene.h4j.properties.Header;
import com.mmoscene.h4j.storage.StorePool;
import org.apache.log4j.Logger;

public class H4J {

    private static Version version = new Version(0, 0, 0, 7);

    private static Config config = new Config();
    private static Network network = new Network();
    private static Header header = new Header();
    private static StorePool pool = new StorePool();

    private static HabboHotel habbo_hotel;
    private static DatabaseObject db_obj;
    private static CommunicationManager communication_manager;

    public static void main(String[] args) {
        getLogger().info("Habbo 4 Java - " + version.string);
        header.load();
        getLogger().info(header.get("ReleaseCode"));
        getLogger().info("");

        config.load("props/server.properties");
        network.listen();
        pool.load();

        if (config.get("environment.database.type").equalsIgnoreCase("grizzly")) {
            db_obj = new Grizzly();
            getLogger().info("Binded to the Grizzly database type!");
        } else if(config.get("environment.database.type").equalsIgnoreCase("phoenix")) {
            db_obj = new Phoenix();
            getLogger().info("Binded to the Phoenix database type!");
        } else {
            getLogger().info("Unsupported database type selected, please fix!");
            System.exit(0);
        }

        communication_manager = new CommunicationManager();

        habbo_hotel = new HabboHotel();
    }

    public static Logger getLogger(String classpath) {
        return Logger.getLogger(classpath);
    }

    private static Logger getLogger() {
        return Logger.getLogger(H4J.class.getName());
    }

    public static Config getConfig() {
        return config;
    }

    public static Network getNetwork() {
        return network;
    }

    public static StorePool getStorage() {
        return pool;
    }

    public static DatabaseObject getDAO() {
        return db_obj;
    }

    public static HabboHotel getHabboHotel() {
        return habbo_hotel;
    }

    public static Header getHeaders() {
        return header;
    }

    public static CommunicationManager getCommunications() {
        return communication_manager;
    }
}
