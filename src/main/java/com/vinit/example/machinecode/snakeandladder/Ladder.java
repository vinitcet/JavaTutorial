package com.vinit.example.machinecode.snakeandladder;

public class Ladder {
    int start;
    int end;

    Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getstart() {
        return start;
    }

    public void setstart(int start) {
        this.start = start;
    }

    public int getend() {
        return end;
    }

    public void setend(int end) {
        this.end = end;
    }
}
