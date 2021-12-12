package com.advent.of.code.day6;

public class Fish {
    private int internalCounter;

    public Fish(int internalCounter) {
        this.internalCounter = internalCounter;
    }

    public boolean decreaseCount() {
        if (internalCounter > 0) {
            internalCounter--;
            return false;
        } else {
            internalCounter = 6;
            return true;
        }
    }
}
