package tema12;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Data;

@Data
public class FestivalGate {
    private Queue<TicketType> ticketTypes = new LinkedList<>();

    public void setTicketTypes(TicketType ticketType) {
        this.ticketTypes.add(ticketType);
    }
    @Override
    public String toString() {
        return "FestivalGate{" +
                "ticketTypes=" + ticketTypes +
                '}';
    }
}
