package ru.karin.nc_hw1.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) &&
                Objects.equals(v2, that.v2) &&
                Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}
