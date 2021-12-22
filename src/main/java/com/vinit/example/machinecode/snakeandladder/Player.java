package com.vinit.example.machinecode.snakeandladder;

public class Player {
    String name;
    int location;
    boolean active;
    int position;

    public Player(String name) {
        this.name = name;
        this.location = 0;
        this.active = true;
        this.position=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
