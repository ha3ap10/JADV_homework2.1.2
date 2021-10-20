package ru.netology;

public class Deal {
    private final double width;
    private final double length;
    private final double saleValue;

    public Deal(double width, double length, double saleValue) {
        this.width = width;
        this.length = length;
        this.saleValue = saleValue;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getSaleValue() {
        return saleValue;
    }

    @Override
    public String toString() {
        return String.format("%,10.2f %,10.2f %,20.2f", width, length, saleValue);
    }
}
