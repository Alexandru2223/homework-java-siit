package quiz;


import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ShapeServiceTest {
    List<Shape> shapes = new ArrayList<>();
    private ShapeService sut;

    @Test
    public void given_all_types_of_shapes_when_computes_total_perimeter_when_total_perimeter_is_returned() {
        //given
        //  ShapeService shapeService = mock(ShapeService.class);
        shapes.add(new Square(100));
        shapes.add(new Triangle(10, 20, 30));
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(10));

        //when

        Double surface = sut.getTotalPerimeter((ArrayList<Shape>) shapes);

        //Then

        assertThat(surface).isCloseTo(582.8, Offset.strictOffset(0.1));
    }

    @Test
    public void given_all_types_of_shapes_when_computes_total_surface_when_total_surface_is_returned() {
        //given
        //  ShapeService shapeService = mock(ShapeService.class);
        shapes.add(new Square(100));
        shapes.add(new Triangle(10, 20, 30));
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(10));

        //when

        Double surface = sut.getTotalSurface((ArrayList<Shape>) shapes);

        //Then

        assertThat(surface).isCloseTo(10614.1, Offset.strictOffset(0.1));

    }

    @Test
    public void given_circle_shape_when_compus_perimeter_then_and_perimeter_is_returned() {
        Shape circle = new Circle(105.5);
        shapes.add(circle);
        Double surface = shapes.get(0).getPerimeter();
        assertThat(surface).isCloseTo(662.8, Offset.strictOffset(0.1));
    }

    @Test
    public void given_circle_shape_when_computes_surface_then_surface_is_returned() {
        Shape circle = new Circle(105.5);
        shapes.add(circle);
        Double surface = shapes.get(0).getSurface();
        assertThat(surface).isCloseTo(34966.7, Offset.strictOffset(0.1));
    }

    @Test
    public void given_rectangle_shape_when_computes_perimeter_and_perimeter_is_returned() {
        Shape rectangle = new Rectangle(10, 20);
        shapes.add(rectangle);
        Double surface = shapes.get(0).getPerimeter();
        assertThat(surface).isEqualTo(60);
    }

    @Test
    public void given_rectangle_shape_when_computes_surface_then_surface_is_returned() {
        Shape rectangle = new Rectangle(10, 20);
        shapes.add(rectangle);
        Double surface = shapes.get(0).getSurface();
        assertThat(surface).isEqualTo(200);
    }

    @Test
    public void given_shape_when_computes_that_already_exist_then_exception_is_returned() {
        //given
        Repository.shapes.add(new Triangle(10, 20, 30));

        //when
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        sut.addShape(new Triangle(10, 20, 30));

        //then
        verify(out).println(startsWith("Similar"));


        //when
       /*Throwable thrown = catchThrowable(
                ()-> sut.addShape(new Triangle(10,20,30))
        )*/
        //Then
        //assertThat(thrown).doesNotThrowAnyException();

        //assertThat(thrown).hasMessage("Similar shapes can't be added to the drawing tool");
    }

    @Test
    public void given_square_shape_when_compues_surface_then_surface_is_returned() {
        Shape square = new Square(100);
        shapes.add(square);
        Double surface = shapes.get(0).getSurface();
        assertThat(surface).isEqualTo(10000);
    }

    @Test
    public void given_square_shape_when_computes_perimeter_then_perimeter_is_returned() {
        Shape square = new Square(100);
        shapes.add(square);
        Double surface = shapes.get(0).getPerimeter();
        assertThat(surface).isEqualTo(400);
    }

    @Test
    public void given_triangle_shape_when_computes_perimeter_then_perimeter_is_returned() {
        Shape triangle = new Triangle(10, 20, 30);
        shapes.add(triangle);
        Double surface = shapes.get(0).getPerimeter();
        assertThat(surface).isEqualTo(60);
    }

    @Test
    public void given_triangle_shape_when_computes_surface_then_surface_is_returned() {
        Shape triangle = new Triangle(10, 20, 30);
        shapes.add(triangle);
        Double surface = shapes.get(0).getSurface();
        assertThat(surface).isEqualTo(100);
    }

    @Before
    public void setup() {
        sut = new ShapeService();
        shapes = new ArrayList<>();
    }
}
