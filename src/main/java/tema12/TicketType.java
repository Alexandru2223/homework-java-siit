package tema12;

//  full, full-vip, free-pass, one-day, one-day-vip;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TicketType {
    FULL, FULLVIP, FREEPASS, ONEDAY, ONEDAYVIP;

    private static final Random RANDOM = new Random();
    private static final List<TicketType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    public static TicketType randomLetter() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
