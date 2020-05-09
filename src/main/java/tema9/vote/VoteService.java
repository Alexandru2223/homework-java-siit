package tema9.vote;
/*      Ați fost angajați de statul român să dezvoltați o aplicație pentru votul electronic. Aveți o bază de date de persoane pe care aplicația o
citește la pornire (10 obiecte incarcate intr-o lista in memorie).
Pentru fiecare persoană din baza de date se cunosc numele, prenumele, adresa, CNP-ul, seria și numărul de buletin.
        De la tastatură se citește o secvență de perechi ”CNP + Nume Candidat” care reprezintă voturi ale persoanelor identificate prin CNP-ul
respectiv pentru candidatul identificat prin nume. Aplicația va rezolva secvențial voturile și le va număra în timp real putând oricând
să afișeze situația de la momentul curent.*/


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class VoteService {

    static PersonRepository rep = new PersonRepository();

    public static void main(String[] args) {
        setVote("188332233442", "Andrei Vlad");
        setVote("19941992330422", "Ioana Andreea");
        setVote("199203491234", "Ioana Andreea");
        setVote("1999102134222", "Andrei Vlad");
        setVote("1978122139444", "Andrei Vlad");
        setVote("1978122139444", "Andrei Vlad");
        setVote("29330223455", "Andrei Vlad");
        printStatus();
    }

    public static void setVote(String cnp, String name) {
        try {
            Person person = getPerson(cnp);
            if (person != null) {
                if (!person.isVoted()) {
                    if (checkCandidateExist(name)) {
                        setPersonVoted(cnp);
                        rep.candidates.put(name, rep.candidates.get(name) + 1);
                    } else {
                        throw new IllegalArgumentException("Candidate " + name + " doesn't exist.");
                    }
                } else {
                    throw new IllegalArgumentException(person.getLastName() + " " + person.getFirstName() + " has already voted.");
                }
            } else {
                throw new IllegalArgumentException("Person with CNP: " + cnp + " doesn't exist.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printStatus() {
        Map<String, Integer> status = rep.candidates.entrySet().stream()
                                                    .sorted(Map.Entry.comparingByValue((value1, value2) -> value2 - value1))
                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value) -> key, LinkedHashMap::new));
        status.forEach((key, value) -> System.out.println(key + " " + value));


    }

    public static Person getPerson(String cnp) {
        return rep.personList.stream()
                             .filter(person -> Objects.nonNull(person))
                             .filter(cnp1 -> cnp1.getCnp().equals(cnp))
                             .findFirst()
                             .orElse(null);

    }


    public static boolean checkCandidateExist(String name) {
        if (rep.candidates.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    public static void setPersonVoted(String cnp) {
        rep.personList.stream()
                      .filter(cnp1 -> cnp1.getCnp().equals(cnp))
                      .findFirst()
                      .get().setVoted(true);
    }
}