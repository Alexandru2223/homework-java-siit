package tema9.vote;
/*      Ați fost angajați de statul român să dezvoltați o aplicație pentru votul electronic. Aveți o bază de date de persoane pe care aplicația o
citește la pornire (10 obiecte incarcate intr-o lista in memorie).
Pentru fiecare persoană din baza de date se cunosc numele, prenumele, adresa, CNP-ul, seria și numărul de buletin.
        De la tastatură se citește o secvență de perechi ”CNP + Nume Candidat” care reprezintă voturi ale persoanelor identificate prin CNP-ul
respectiv pentru candidatul identificat prin nume. Aplicația va rezolva secvențial voturile și le va număra în timp real putând oricând
să afișeze situația de la momentul curent.*/


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Person {
    private String lastName;
    private String firstName;
    private String adress;
    private String CNP;
    private String series;
    private int number;

}
