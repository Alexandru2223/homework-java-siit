package tema12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FestivalService {
    public static void main(String[] args) {
        ScheduledExecutorService ticketTypeThread = Executors.newSingleThreadScheduledExecutor();
        FestivalGate gate = new FestivalGate();
        FestivalStatisticThread festivalStatisticThread = new FestivalStatisticThread(gate);
        ticketTypeThread.scheduleAtFixedRate(() -> {
            TicketType ticketType = TicketType.getRandomTicket();
            FestivalAtendeeThread festivalAtendee = new FestivalAtendeeThread(ticketType, gate);
            festivalAtendee.getScheduledExecutorService()
                           .schedule(() -> gate.setTicketTypes(ticketType), 2, TimeUnit.SECONDS);
        }, 0, 4, TimeUnit.SECONDS);


        festivalStatisticThread.getScheduledExecutorService().scheduleAtFixedRate(() ->
                        printStatistic(gate)
                , 0, 5, TimeUnit.SECONDS);
    }

    private static void printStatistic(FestivalGate gate) {
        int full;
        int fullVip;
        int freePass;
        int oneDay;
        int oneDayVip;
        freePass = (int) gate.getTicketTypes().stream().filter(ticketType -> ticketType.toString().equals("FREEPASS")).count();
        full = (int) gate.getTicketTypes().stream().filter(ticketType -> ticketType.toString().equals("FULL")).count();
        fullVip = (int) gate.getTicketTypes().stream().filter(ticketType -> ticketType.toString().equals("FULLVIP")).count();
        oneDay = (int) gate.getTicketTypes().stream().filter(ticketType -> ticketType.toString().equals("ONEDAY")).count();
        oneDayVip = (int) gate.getTicketTypes().stream().filter(ticketType -> ticketType.toString().equals("ONEDAYVIP")).count();
        System.out.println("-------------------------------");
        System.out.println(gate.getTicketTypes().size() + " people entered");
        System.out.println(freePass + " have free pass tickets");
        System.out.println(full + " have full tickets");
        System.out.println(fullVip + " have full vip tickets");
        System.out.println(oneDay + " have one day tickets");
        System.out.println(oneDayVip + " have one day vip tickets");
        System.out.println("-------------------------------");
    }
}
