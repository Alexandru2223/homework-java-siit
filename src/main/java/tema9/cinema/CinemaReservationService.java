package tema9.cinema;
/*Create a seat reservation app for seats to a cinema.
        Entities: Cinema (name:string, seats:set/map), Seat (seatNumber:string, reserved:boolean, price:BigDecimal)
        Relations: Cinema has a Set<Seat> but may also be designed like Map<String, Seat> where the key is the seatNumber
        Actions (defined in CinemaReservationService): seatReservation, cancelling the reservation.
        The app will store in memory a number of 100 seats: A01, A02, ...,B01, B02,... J10 for a given cinema.*/


public class CinemaReservationService {

    static CinemaRepository rep = new CinemaRepository();

    public static void main(String[] args) {

        makeReservation("A01");
        makeReservation("A03");
        makeReservation("B11");
        makeReservation("C12");
        makeReservation("A1");
        makeReservation("A03");
        cancelReservation("A03");

        //  System.out.println(rep.seatMap);
        //  rep.seatMap.forEach((s, seat) -> System.out.println(s + " " + seat.isReserved()));

    }

    private static void makeReservation(String seatNumber) {
        try {
            if (!rep.seatMap.containsKey(seatNumber)) {
                throw new IllegalArgumentException("Seat " + seatNumber + " doesn't exist.");
            } else {
                if (rep.seatMap.get(seatNumber).isReserved()) {
                    throw new IllegalArgumentException("Seat " + seatNumber + " is already reserved.");
                } else {
                    rep.seatMap.get(seatNumber).setReserved(true);
                    System.out.println(seatNumber + " succesfully reserved.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void cancelReservation( String seatNumber) {
        try {
            if (!rep.seatMap.containsKey(seatNumber)) {
                throw new IllegalArgumentException("Seat " + seatNumber + " doesn't exist.");
            } else {
                if (!rep.seatMap.get(seatNumber).isReserved()) {
                    throw new IllegalArgumentException("Seat " + seatNumber + " is already free.");
                } else {
                    rep.seatMap.get(seatNumber).setReserved(false);
                    System.out.println(seatNumber + " succesfully canceled.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
