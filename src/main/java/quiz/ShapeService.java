package quiz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ShapeService {
    private static ShapeService service = new ShapeService();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####0.00");
        boolean k = true;
        while (k) {
            System.out.println("Enter 1 to add a shape");
            System.out.println("Enter 2 to display all surfaces and perimeters");
            System.out.println("Enter 3 to display total surface and perimeter");
            System.out.println("Enter x to close");
            String key = scan.next();
            switch (key) {
                case "1":
                    System.out.println("Enter type of shape you want to add");
                    String type = scan.next();
                    switch (type) {
                        case "square": {
                            System.out.println("Enter length");
                            double length = scan.nextDouble();
                            service.addShape(new Square(length));
                            break;
                        }
                        case "rectangle": {
                            System.out.println("Enter length and width");
                            double length = scan.nextDouble();
                            double width = scan.nextDouble();
                            service.addShape(new Rectangle(length, width));
                            break;
                        }
                        case "circle":
                            System.out.println("Enter radius");
                            double radius = scan.nextDouble();
                            service.addShape(new Circle(radius));
                            break;
                        case "triangle":
                            System.out.println("Enter length1, length2, length3");
                            double length1 = scan.nextDouble();
                            double length2 = scan.nextDouble();
                            double length3 = scan.nextDouble();
                            service.addShape(new Triangle(length1, length2, length3));
                            break;
                    }
                    break;
                case "2":
                    for (Shape shapes : Repository.shapes) {
                        System.out.println(
                                shapes + ", " + "Surface: " + df.format(shapes.getSurface()) + ", " + "Perimeter: " + df.format(shapes.getPerimeter()));
                    }
                    break;
                case "3":
                    System.out.println("Total surface: " + df.format(service.getTotalSurface((ArrayList<Shape>) Repository.shapes)));
                    System.out.println("Total perimeter: " + df.format(service.getTotalPerimeter((ArrayList<Shape>) Repository.shapes)));
                    break;
                case "x":
                    k = false;
                    break;
            }
        }


    }

    public void addShape(Shape shape) {
        boolean key = false;
        try {
            for (Shape shape1 : Repository.shapes) {
                if (shape1.equals(shape)) {
                    throw new IllegalArgumentException();
                } else {
                    key = true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Similar shapes can't be added to the drawing tool");
        }
        if (key) {
            Repository.shapes.add(shape);
        }
    }

    public double getTotalSurface(ArrayList<Shape> shapes) {
        double surface = 0;
        for (Shape shape : shapes) {
            surface += shape.getSurface();
        }
        return surface;
    }

    public double getTotalPerimeter(ArrayList<Shape> shapes) {
        double perimeter = 0;
        for (Shape shape : shapes) {
            perimeter += shape.getPerimeter();
        }
        return perimeter;
    }
}
