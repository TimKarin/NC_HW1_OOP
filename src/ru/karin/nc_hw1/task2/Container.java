package ru.karin.nc_hw1.task2;

public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int hight) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + hight;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2-x1;
    }

    public int getHight() {
        return y2-y1;
    }

    public boolean collides(Ball ball) {
        return (ball.getX()-ball.getRadius() > x1) && (ball.getX()+ball.getRadius() < x2)
                && (ball.getY()-ball.getRadius() > y1) && (ball.getY()+ball.getRadius() < y2);
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }
}
