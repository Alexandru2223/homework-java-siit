package tema9.vote;
/*      Ați fost angajați de statul român să dezvoltați o aplicație pentru votul electronic. Aveți o bază de date de persoane pe care aplicația o
citește la pornire (10 obiecte incarcate intr-o lista in memorie).
Pentru fiecare persoană din baza de date se cunosc numele, prenumele, adresa, CNP-ul, seria și numărul de buletin.
        De la tastatură se citește o secvență de perechi ”CNP + Nume Candidat” care reprezintă voturi ale persoanelor identificate prin CNP-ul
respectiv pentru candidatul identificat prin nume. Aplicația va rezolva secvențial voturile și le va număra în timp real putând oricând
să afișeze situația de la momentul curent.*/

public class VoteService {

    private static PersonRepository rep;
    public static void main(String[] args) {

        setVote("188332233442", "Andrei Vlad");
        System.out.println(rep.candidates);
    }

    private static void setVote(String cnp, String name) {
        try {
            rep.personList.forEach(person -> {
                if (person.getCNP().equals(cnp)) {
                    rep.candidates.forEach((key, value) -> {
                        if (key.equals(name)) {
                            rep.candidates.put(key, value+1);
                        } else{
                            throw new IllegalArgumentException(name + " is not a candidate!");
                        }
                    });
                } else {
                    throw new IllegalArgumentException("Wrong CNP!");
                }
            });
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

