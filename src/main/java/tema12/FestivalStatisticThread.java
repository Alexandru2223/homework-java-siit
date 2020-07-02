package tema12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FestivalStatisticThread {
    private FestivalGate gate;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

}
