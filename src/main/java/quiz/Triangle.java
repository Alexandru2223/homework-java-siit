package quiz;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Triangle implements Shape {
    private double length1;
    private double length2;
    private double length3;


    @Override
    public double getSurface() {
        double cosy = (length1 + length2 - length3) / (2 * length1 * length2);
        double ha = length2 * Math.sqrt(1 - Math.pow(cosy, 2));
        return (length1 * ha) / 2;
    }

    @Override
    public double getPerimeter() {
        return length1 + length2 + length3;
    }
}
