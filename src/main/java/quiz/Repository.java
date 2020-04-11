package quiz;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static final List<Shape> shapes = new ArrayList<>();

    static {
        shapes.add(new Square(123));
        shapes.add(new Circle(10));
        shapes.add(new Square(15));
        shapes.add(new Rectangle(12, 32));
        shapes.add(new Triangle(12, 15, 12));
    }
}
