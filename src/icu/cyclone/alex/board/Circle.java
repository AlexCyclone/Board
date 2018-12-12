package icu.cyclone.alex.board;

public class Circle extends Shape {
    private Point o;
    private double r;

    public Circle() {
        o = new Point();
    }

    public Circle(Point o, double r) {
        this.o = o;
        this.r = r;
    }

    public Point getO() {
        return o;
    }

    public void setO(Point o) {
        this.o = o;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return "Circle[o = " + o + ", r = " + r + "]";
    }
}
