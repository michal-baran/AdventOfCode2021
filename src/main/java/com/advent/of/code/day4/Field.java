package com.advent.of.code.day4;

public class Field {
    private int number;
    private boolean marked = false;

    public Field(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMark() {
        this.marked = true;
    }
}
