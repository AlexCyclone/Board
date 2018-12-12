package icu.cyclone.alex.board;

import java.util.Arrays;

public class Board {
    Shape[] places = new Shape[4];

    public Board() {
    }

    public boolean putShape(Shape shape, int place) {
        if (place < 0 || place >= places.length) {
            return false;
        }
        if (places[place] == null) {
            places[place] = shape;
            return true;
        }
        return false;
    }

    public Shape getShape(int place) {
        if (place < 0 || place >= places.length) {
            return null;
        }
        Shape shape = places[place];
        places[place] = null;
        return shape;
    }

    public double totalArea() {
        double area = 0;
        for (Shape shape: places) {
            area += shape != null ? shape.getArea() : 0;
        }
        return area;
    }

    @Override
    public String toString() {
        return "Board" + Arrays.toString(places) + " Total area = " + totalArea();
    }
}
