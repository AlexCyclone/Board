package icu.cyclone.alex.board;

import java.util.Arrays;

public class Triangle extends Shape {
    private Point[] edges = new Point[3];

    public Triangle() {
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Point();
        }
    }

    public Triangle(Point... edge) {
        setEdges(edge);
    }

    public Point[] getEdges() {
        return edges;
    }

    public void setEdges(Point[] edges) {
        if (edges.length != 3) {
            throw new IllegalArgumentException("Incorrect edges count");
        }
        this.edges = edges;
    }

    private double[] getSides() {
        double[] sides = new double[3];
        sides[0] = edges[0].distance(edges[1]);
        sides[1] = edges[1].distance(edges[2]);
        sides[2] = edges[2].distance(edges[0]);
        return sides;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        double[] sides = getSides();
        return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
    }

    @Override
    public double getPerimeter() {
        return Arrays.stream(getSides()).sum();
    }

    @Override
    public String toString() {
        return "Triangle" + Arrays.toString(edges);
    }
}
