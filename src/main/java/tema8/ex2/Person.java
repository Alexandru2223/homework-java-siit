package tema8.ex2;


import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Person {
    private String namePerson;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return namePerson.equals(person.namePerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson);
    }
}
