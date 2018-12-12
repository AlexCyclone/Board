package icu.cyclone.alex;

import icu.cyclone.alex.board.*;

public class Test {
    public static void start() {
        Shape[] s = new Shape[4];
        s[0] = new Triangle(new Point(0,0), new Point(0,5),new Point(5,0));
        s[1] = new Rectangle(new Point(0,4), new Point(5,0));
        s[2] = new Circle(new Point(), 3);
        s[3] = new Circle();

        for (Shape shapes: s) {
            System.out.println(shapes + "; Area = " + shapes.getArea() + "; Perimeter = " + shapes.getPerimeter());
        }

        Board b = new Board();
        System.out.println(b);

        b.putShape(s[3],-2);
        b.putShape(s[3],4);
        System.out.println(b);

        for (int i = 0; i < s.length; i++) {
            b.putShape(s[i], i);
            System.out.println(b);
        }

        for (int i = 0; i < s.length; i++) {
            System.out.println(b.getShape(i));
            System.out.println(b);
        }
    }
}
