package ru.karin.nc_hw1.task2;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(2, 3, 4, 3, -60);
        Container container = new Container(0, 0, 20, 30);

        System.out.println(ball);
        System.out.println(container);
        System.out.println("ball in container: " + container.collides(ball));
        System.out.println();

        ball.move();
        System.out.println("ball was moved");
        System.out.println(ball);
        System.out.println(container);
        System.out.println("ball in container: " + container.collides(ball));
        System.out.println();

        ball.move();
        System.out.println("ball was moved");
        System.out.println(ball);
        System.out.println(container);
        System.out.println("ball in container: " + container.collides(ball));
        System.out.println();



    }


}
