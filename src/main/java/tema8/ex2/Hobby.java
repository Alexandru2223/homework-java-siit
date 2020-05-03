package tema8.ex2;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Hobby {
    private String name;
    private int frequency;
    private List<String> adress;




}
