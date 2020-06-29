package tema12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import lombok.Data;

@Data
public class FestivalAtendeeThread {
    private String ticketType;
    FestivalGate gate;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
}
