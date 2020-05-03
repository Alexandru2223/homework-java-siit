package tema8.ex2;

import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;

public class Service {
    public static void main(String[] args) {
        HashMap<Person, List<Hobby>> hobbies = new HashMap<>();
        Person p1 = Person.builder()
                          .namePerson("Alex")
                          .build();
        Hobby h1 = Hobby.builder()
                        .name("swiming")
                        .frequency(5)
                        .adress(Lists.list("Romania", "Italia"))
                        .build();
        Hobby h2 = Hobby.builder()
                        .name("surfing")
                        .frequency(4)
                        .adress(Lists.list("USA", "Australia"))
                        .build();

        Person p2 = Person.builder()
                          .namePerson("Daniel")
                          .build();
        Hobby h3 = Hobby.builder()
                        .name("snowboarding")
                        .frequency(6)
                        .adress(Lists.list("Austria", "France"))
                        .build();
        Hobby h4 = Hobby.builder()
                        .name("football")
                        .frequency(2)
                        .adress(Lists.list("Spain"))
                        .build();
        Hobby h5 = Hobby.builder()
                        .name("karate")
                        .frequency(7)
                        .adress(Lists.list("China", "Japan", "Coreea"))
                        .build();
        Person p3 = Person.builder()
                          .namePerson("Alex")
                          .build();
        Hobby h6 = Hobby.builder()
                        .name("fishing")
                        .frequency(5)
                        .adress(Lists.list("Mexico", "Sri Lanka"))
                        .build();
        hobbies.put(p1, Lists.list(h1, h2));
        hobbies.put(p2, Lists.list(h3, h4, h5));
        hobbies.put(p3, Lists.list(h6));
        hobbies.forEach((key, value) -> value.forEach((index) -> System.out.println(key.getNamePerson() +": " +"Name of hobby: " + index.getName() + " - Adress: " +index.getAdress())));
    }


}
