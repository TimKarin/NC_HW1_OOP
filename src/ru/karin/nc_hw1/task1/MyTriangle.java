package ru.karin.nc_hw1.task1;

public class MyTriangle {

    enum triangleType {equilateral, isosceles, scalene}

    private MyPoint v1, v2, v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ']';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public triangleType getType() {
        double eps = 1E-7;
        if ((Math.abs(v1.distance(v2) - v2.distance(v3)) < eps) && (Math.abs(v1.distance(v2) - v1.distance(v3)) < eps))
            return triangleType.equilateral;
        else if ((Math.abs(v1.distance(v2) - v2.distance(v3)) < eps) ||
                (Math.abs(v1.distance(v2) - v1.distance(v3)) < eps) ||
                (Math.abs(v3.distance(v2) - v1.distance(v3)) < eps))
            return triangleType.isosceles;
        else
            return triangleType.scalene;
    }
}
