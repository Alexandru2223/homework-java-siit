package tema15;

import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DateAndTime {
    public static void main(String[] args) {
        int year = 2020;
        int month = 3;
        LocalDate date = LocalDate.of(2020,3,13);
        System.out.println(checkFriday13Th(date));
        getLengthOfMonths(year);
        getMondays(month);
    }

    private static boolean checkFriday13Th(@NotNull LocalDate date) {
        int checkFriday = date.getDayOfWeek().compareTo(DayOfWeek.FRIDAY);
        int dayOfMonth = date.getDayOfMonth();
        return checkFriday == 0 && dayOfMonth == 13;
    }

    @NotNull
    private static List<Integer> getMondays(int month) {
        int year = LocalDate.now().getYear();
        List<Integer> mondays = new ArrayList<>();
        int lengthOfMonth = LocalDate.of(year,month,1).lengthOfMonth();
        for (int i=1; i<= lengthOfMonth; i++ ) {
            LocalDate date = LocalDate.of(year, month, i);
            int dayNumber = date.getDayOfWeek().compareTo(DayOfWeek.MONDAY);
            if(dayNumber == 0)
                mondays.add(dayNumber);
            }
        return mondays;
        }


    private static void getLengthOfMonths(int year) {
        for(int i=1;i<13;i++) {
            LocalDate date = LocalDate.of(year, i, 1);
            System.out.println(Month.of(i) + ": " + date.lengthOfMonth());
        }
    }
}
