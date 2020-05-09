package tema9.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {
    public final static List<Person> personList = new ArrayList<>();
    public final static Map<String, Integer> candidates = new HashMap<>();

    public PersonRepository(){
        personList.add(new Person.PersonBuilder()
                  .lastName("Pop")
                  .firstName("Andrei")
                  .adress("Bucuresti")
                  .cnp("19941992330422")
                  .series("B")
                  .number(123992)
                  .voted(false)
                  .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Ioan")
                .firstName("Daniel")
                .adress("Bucuresti")
                .cnp("199203491234")
                .series("AG")
                .number(193884)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Stefan")
                .firstName("Alexandru")
                .adress("Pitesti")
                .cnp("1945002399182")
                .series("AG")
                .number(990443)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Geanta")
                .firstName("Daniel")
                .adress("Slatina")
                .cnp("1999102134222")
                .series("OT")
                .number(100234)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("David")
                .firstName("Andrei")
                .adress("Constanta")
                .cnp("1978122139444")
                .series("CT")
                .number(554433)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Florescu")
                .firstName("Ioana")
                .adress("Alexandria")
                .cnp("29330223455")
                .series("IF")
                .number(788345)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Cristea")
                .firstName("Andreea")
                .adress("Bucuresti")
                .cnp("2011933234405")
                .series("B")
                .number(001232)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Andrei")
                .firstName("Alexandra")
                .adress("Cluj-Napoca")
                .cnp("2933222203112")
                .series("CJ")
                .number(122222)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Andrei")
                .firstName("Cristinel")
                .adress("Buzau")
                .cnp("188332233442")
                .series("BZ")
                .number(199231)
                .voted(false)
                .build());

        personList.add(new Person.PersonBuilder()
                .lastName("Ciutescu")
                .firstName("Andreea")
                .adress("Bucuresti")
                .cnp("2339112322314")
                .series("B")
                .number(777777)
                .voted(false)
                .build());

        candidates.put("Andrei Vlad", 0);
        candidates.put("Ioana Andreea", 0);
        candidates.put("Florescu Andrei", 0);
    }
}
