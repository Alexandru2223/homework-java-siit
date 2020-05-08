package tema9.cinema;

/*Create a seat reservation app for seats to a cinema.
        Entities: Cinema (name:string, seats:set/map), Seat (seatNumber:string, reserved:boolean, price:BigDecimal)
        Relations: Cinema has a Set<Seat> but may also be designed like Map<String, Seat> where the key is the seatNumber
        Actions (defined in CinemaReservationService): seatReservation, cancelling the reservation.
        The app will store in memory a number of 100 seats: A01, A02, ...,B01, B02,... J10 for a given cinema.*/

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cinema {
    private String name;
    Set<Seat>  seats;
}
