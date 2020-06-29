package tema12;

public class FestivalService {
    public static void main(String[] args) {
        TicketType ticketType = TicketType.randomLetter();
        FestivalGate gate = new FestivalGate();
        FestivalAtendeeThread festivalAtendee = new FestivalAtendeeThread();

    }
}
