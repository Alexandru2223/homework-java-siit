package quiz;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Square implements Shape {
    private double length;

    @Override
    public double getSurface() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }
}