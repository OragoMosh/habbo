package com.mmoscene.h4j.communication.events.room;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.communication.GameEvent;
import com.mmoscene.h4j.communication.Request;
import com.mmoscene.h4j.communication.composers.room.SendRoomActorStatusMessageComposer;
import com.mmoscene.h4j.habbohotel.pathfinding.Position;
import com.mmoscene.h4j.network.sessions.Session;
import org.magicwerk.brownies.collections.GapList;

import java.util.LinkedList;

public class RoomActorWalkMessageEvent implements GameEvent {
    @Override
    public void parse(Session session, Request request) {
        int x = request.readInt();
        int y = request.readInt();

        session.getHabbo().getRoomActor().getGoalPosition().setX(x);
        session.getHabbo().getRoomActor().getGoalPosition().setY(y);
        session.getHabbo().getRoomActor().setMoving(true);
    }
}
