package ru.karin.nc_hw1.task2;

import java.util.Objects;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;
    private double eps = 1e-6;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() {
        return Math.abs(imag) < eps;
    }

    public boolean isImaginary() {
        return !isReal();
    }

    public boolean equals(double real, double imag) {
        return Math.abs(this.real-real)<eps && Math.abs(this.imag-imag)<eps;
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.imag);
    }

    public double magnitude() {
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument() {
        if ((Math.abs(real)<eps) && (Math.abs(imag)<eps)){
            throw new ArithmeticException("argument undefined");
        }
        else if (real > 0) {
            return Math.atan(imag/real);
        }
        else if ((real<0) && (imag > 0)) {
            return Math.atan(imag/real) + Math.PI;
        }
        else if ((real<0) && (imag < 0)) {
            return Math.atan(imag/real) - Math.PI;
        }
        else
            return 0;
    }

    public MyComplex add(MyComplex right) {
        real += right.real;
        imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real+right.real, this.imag+right.imag);
    }

    public MyComplex subtract(MyComplex right) {
        real -= right.real;
        imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real-right.real, this.imag-right.imag);
    }

    public MyComplex multyply(MyComplex right) {
        double realResult = this.real*right.real - this.imag*right.imag;
        double imagResult = this.imag*right.real + this.real*right.imag;
        this.setValue(realResult, imagResult);
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double realResult = (this.real*right.real + this.imag*right.imag);
        double imagResult = this.imag*right.real - this.real*right.imag;
        double denom = right.real*right.real + right.imag*right.imag;
        this.setValue(realResult/denom, imagResult/denom);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }
}
