package icu.cyclone.alex.board;

import java.util.Arrays;

public class Rectangle extends Shape {
    private Point[] edges = new Point[4];

    public Rectangle() {
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Point();
        }
    }

    public Rectangle(Point... edge) {
        setEdges(edge);
    }

    public Point[] getEdges() {
        return edges;
    }

    public void setEdges(Point[] edges) {
        if (edges.length != 2) {
            throw new IllegalArgumentException("Incorrect edges count");
        }
        double minX = edges[0].getX() < edges[1].getX() ? edges[0].getX() : edges[1].getX();
        double minY = edges[0].getY() < edges[1].getY() ? edges[0].getY() : edges[1].getY();
        double maxX = edges[0].getX() > edges[1].getX() ? edges[0].getX() : edges[1].getX();
        double maxY = edges[0].getY() > edges[1].getY() ? edges[0].getY() : edges[1].getY();

        this.edges[0] = new Point(minX, minY);
        this.edges[1] = new Point(minX, maxY);
        this.edges[2] = new Point(maxX, maxY);
        this.edges[3] = new Point(maxX, minY);
    }

    private double[] getSides() {
        double[] sides = new double[4];
        sides[0] = edges[0].distance(edges[1]);
        sides[1] = edges[1].distance(edges[2]);
        sides[2] = edges[2].distance(edges[3]);
        sides[3] = edges[3].distance(edges[0]);
        return sides;
    }

    @Override
    public double getArea() {
        double[] sides = getSides();
        return sides[0] * sides[1];
    }

    @Override
    public double getPerimeter() {
        return Arrays.stream(getSides()).sum();
    }

    @Override
    public String toString() {
        return "Rectangle" + Arrays.toString(edges);
    }
}
