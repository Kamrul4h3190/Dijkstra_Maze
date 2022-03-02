package com.company;

public class Cell {
    int x,y,cost;
    public Cell(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")"+":"+cost+"    ";
    }
}