package com.mmoscene.h4j.habbohotel.pathfinding.simple;

import com.mmoscene.h4j.H4J;
import com.mmoscene.h4j.habbohotel.pathfinding.Pathfinder;
import com.mmoscene.h4j.habbohotel.pathfinding.Position;
import com.mmoscene.h4j.habbohotel.rooms.Room;
import com.mmoscene.h4j.habbohotel.rooms.models.SquareState;

import java.awt.*;
import java.util.LinkedList;

public class SimplePathfinder implements Pathfinder {
    private Point[] proximity = new Point[] {
        new Point(0, -1),
        new Point(0, 1),
        new Point(1, 0),
        new Point(-1, 0),
        new Point(1, -1),
        new Point(-1, 1),
        new Point(1, 1),
        new Point(-1, -1)
    };

    public Position getNextNode(Position current, Position end, Room room) {
        Position p = new Position(0, 0, 0, 0);

        double pointer = current.distanceFrom(end);

        for(Point c : proximity) {
            Position n = new Position(c.x + current.getX(), c.y + current.getY(), current.getZ(), 0);

            if (n.getX() < 0 && n.getY() < 0) { //it isn't a real tile..
                continue;
            }

            if (n.getX() > room.getModel().getLimitX() || n.getY() > room.getModel().getLimitY()) { //it's above the limits
                continue;
            }

            if (room.getModel().getSquares()[n.getX()][n.getY()] == SquareState.CLOSED) { //it's a closed tile anyways
                continue;
            }

            if (pointer > n.distanceFrom(end)) {
                pointer = n.distanceFrom(end);
                p = n;
            }
        }

        return p;
    }

    public LinkedList<Position> calculatePath(Position start, Position end, Room room) {
        LinkedList<Position> path = new LinkedList<>();

        double limit = start.distanceFrom(end);
        H4J.getLogger("a").info("Le limit: " + limit);
        double distancePointer = limit;
        Position current = start;
        Position lastCurrent = current;

        while(true) {
            for(Point p : proximity) {
                Position n = new Position(p.x + current.getX(), p.y + current.getY(), 0, 0); //TODO: Z

                if (n.getX() < 0 && n.getY() < 0) { //it isn't a real tile..
                    continue;
                }

                if (n.getX() > room.getModel().getLimitX() || n.getY() > room.getModel().getLimitY()) { //it's above the limits
                    continue;
                }

                if (room.getModel().getSquares()[n.getX()][n.getY()] == SquareState.CLOSED) { //it's a closed tile anyways
                    continue;
                }

                if (distancePointer > n.distanceFrom(end)) {  //it's out of bounds
                    distancePointer = n.distanceFrom(end);
                    H4J.getLogger("a").info(limit + " => " + n.getX() + "|" + n.getY());
                    current = n;
                }
            }

            path.add(current);
            limit--;
            distancePointer = current.distanceFrom(end);

            if (limit <= 0) {
                H4J.getLogger("a").info("we broke it!");
                break;
            }
        }
        return path;
    }
}
