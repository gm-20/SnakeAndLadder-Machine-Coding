package model;

import java.util.UUID;

public class Player {

    //Member Variables
    String name;
    int pos = 0;
    String id;


    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPos(int x) {
        this.pos = x;
    }

    public int getPos() {
        return pos;
    }
}
