package tema8.ex1;

import java.util.Comparator;
import java.util.TreeSet;

public class PersonService {
    public static void main(String[] args) {


        TreeSet<Person> people = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getName().equals(o2.getName()))
                    return Integer.compare(o1.getAge(), o2.getAge());
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });

        Person person1 = Person.builder()
                               .name("George")
                               .age(19)
                               .build();
        Person person2 = Person.builder()
                               .name("Alex")
                               .age(21)
                               .build();
        Person person3 = Person.builder()
                               .name("Daniel")
                               .age(10)
                               .build();
        Person person4 = Person.builder()
                               .name("Daniel")
                               .age(15)
                               .build();
        Person person5 = Person.builder()
                               .name("Ana")
                               .age(24)
                               .build();
        Person person6 = Person.builder()
                               .name("Andreea")
                               .age(19)
                               .build();
        Person person7 = Person.builder()
                               .name("Silvius")
                               .age(34)
                               .build();
        Person person8 = Person.builder()
                               .name("Alex")
                               .age(13)
                               .build();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);


        people.forEach(System.out::println);
    }
}
