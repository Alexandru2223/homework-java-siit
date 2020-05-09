package tema8.ex2;


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
                        .adress(List.of("Romania", "Italia"))
                        .build();
        Hobby h2 = Hobby.builder()
                        .name("surfing")
                        .frequency(4)
                        .adress(List.of("USA", "Australia"))
                        .build();

        Person p2 = Person.builder()
                          .namePerson("Daniel")
                          .build();
        Hobby h3 = Hobby.builder()
                        .name("snowboarding")
                        .frequency(6)
                        .adress(List.of("Austria", "France"))
                        .build();
        Hobby h4 = Hobby.builder()
                        .name("football")
                        .frequency(2)
                        .adress(List.of("Spain"))
                        .build();
        Hobby h5 = Hobby.builder()
                        .name("karate")
                        .frequency(7)
                        .adress(List.of("China", "Japan", "Coreea"))
                        .build();
        Person p3 = Person.builder()
                          .namePerson("Alex")
                          .build();
        Hobby h6 = Hobby.builder()
                        .name("fishing")
                        .frequency(5)
                        .adress(List.of("Mexico", "Sri Lanka"))
                        .build();
        hobbies.put(p1, List.of(h1, h2));
        hobbies.put(p2, List.of(h3, h4, h5));
        hobbies.put(p3, List.of(h6));
        hobbies.forEach((key, value) -> value
                .forEach((index) -> System.out.println(key.getNamePerson() + ": " + "Name of hobby: " + index.getName() + " - Adress: " + index.getAdress())));
    }


}
