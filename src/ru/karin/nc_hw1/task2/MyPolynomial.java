package ru.karin.nc_hw1.task2;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String polynomStr = "";
        if (coeffs.length > 0)
            polynomStr = Double.toString(coeffs[0]);
        if (coeffs.length > 1)
            polynomStr = coeffs[1] + "x+" + polynomStr;
        if (coeffs.length > 2) {
            for (int i = 2; i<coeffs.length; i++) {
                polynomStr = coeffs[i] + "x^" + i + "+" + polynomStr;
            }
        }
        return polynomStr;
    }

    public double evaluate(double x) {
        double result = coeffs[0];
        for (int i=1; i<coeffs.length; i++)
            result += coeffs[i] * Math.pow(x, i);
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] newCoeffs = new double[maxDegree+1];
        int i = 0;
        while ((i < this.coeffs.length) && (i < right.coeffs.length)) {
            newCoeffs[i] = this.coeffs[i] + right.coeffs[i];
            i++;
        }
        while (i < this.coeffs.length) {
            newCoeffs[i] = this.coeffs[i];
            i++;
        }
        while (i < right.coeffs.length) {
            newCoeffs[i] = right.coeffs[i];
            i++;
        }
        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multyply(MyPolynomial right) {
        double[] newCoeffs = new double[this.getDegree()+right.getDegree()+1];
        for (int i=0; i<this.coeffs.length; i++) {
            for (int j=0; j<right.coeffs.length; j++) {
                newCoeffs[i+j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
