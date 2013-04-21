package com.mmoscene.h4j.habbohotel.rooms.actors;

import com.mmoscene.h4j.communication.Response;
import com.mmoscene.h4j.communication.composers.room.SendRoomActorStatusMessageComposer;
import com.mmoscene.h4j.habbohotel.pathfinding.Position;
import com.mmoscene.h4j.habbohotel.rooms.Room;
import gnu.trove.map.hash.THashMap;

import java.util.Map;

public class RoomActor {
    private Position current_position, goal_position = new Position(0, 0, 0, 0);

    private Room current_room;

    private int id, rotation, drink, idle_time = 0;

    private boolean moving, idle;

    private THashMap<String, Object> status = new THashMap<>();

    private Thread walk_task;

    public RoomActor(int id) {
        this.id = id;

        walk_task = new Thread(new WalkTask(this));

        walk_task.start();
    }

    public Position getCurrentPosition() {
        return current_position;
    }

    public void setCurrentPosition(Position current_position) {
        this.current_position = current_position;
    }

    public Position getGoalPosition() {
        return goal_position;
    }

    public void setGoalPosition(Position goal_position) {
        this.goal_position = goal_position;
    }

    public Room getCurrentRoom() {
        return current_room;
    }

    public void setCurrentRoom(Room current_room) {
        this.current_room = current_room;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getIdleTime() {
        return idle_time;
    }

    public void setIdleTime(int idle_time) {
        this.idle_time = idle_time;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public void clearStatus() {
        status = new THashMap<>();
    }

    public boolean hasStatus(String key) {
        return status.containsKey(key);
    }

    public void addStatus(String key, Object val) {
        removeStatus(key);

        status.put(key, val);
    }

    public void removeStatus(String key) {
        status.remove(key);
    }

    public String getStatus() {
        String st = "/";

        for(Map.Entry<String, Object> s : status.entrySet()) {
            st += s.getKey() + " " + s.getValue() + "/";
        }

        st += "/";

        return st;
    }

    public Response getRoomActorStatusMessageComposer() {
        return SendRoomActorStatusMessageComposer.compose(
                id,
                getCurrentPosition(),
                getStatus()
        );
    }

    public void sendRoomActorStatusMessageComposer() {
        getCurrentRoom().respond(getRoomActorStatusMessageComposer());
    }
}
