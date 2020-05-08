package tema9.cinema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CinemaRepository {
    List<Cinema> cinemas = new ArrayList<>();
    Set<Seat> cinemaSeats = new LinkedHashSet<>();
    Map<String, Seat>  seatMap = new HashMap<>();
    public CinemaRepository(){

        cinemaSeats.add(new Seat("A01",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A02",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A03",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A04",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A05",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A06",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A07",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A08",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A09",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A10",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A11",false, new BigDecimal("20.34")));
        cinemaSeats.add(new Seat("A12",false, new BigDecimal("20.34")));

        cinemaSeats.add(new Seat("B01",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B02",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B03",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B04",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B05",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B06",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B07",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B08",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B09",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B10",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B11",false, new BigDecimal("21.49")));
        cinemaSeats.add(new Seat("B12",false, new BigDecimal("21.49")));

        cinemaSeats.add(new Seat("C01",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C02",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C03",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C04",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C05",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C06",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C07",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C08",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C09",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C10",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C11",false, new BigDecimal("22.49")));
        cinemaSeats.add(new Seat("C12",false, new BigDecimal("22.49")));

        cinemaSeats.add(new Seat("D01",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D02",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D03",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D04",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D05",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D06",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D07",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D08",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D09",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D10",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D11",false, new BigDecimal("23.49")));
        cinemaSeats.add(new Seat("D12",false, new BigDecimal("23.49")));

        cinemaSeats.add(new Seat("E01",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E02",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E03",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E04",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E05",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E06",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E07",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E08",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E09",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E10",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E11",false, new BigDecimal("24.49")));
        cinemaSeats.add(new Seat("E12",false, new BigDecimal("24.49")));

        cinemaSeats.add(new Seat("F01",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F02",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F03",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F04",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F05",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F06",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F07",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F08",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F09",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F10",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F11",false, new BigDecimal("28.99")));
        cinemaSeats.add(new Seat("F12",false, new BigDecimal("28.99")));

        cinemaSeats.add(new Seat("G01",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G02",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G03",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G04",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G05",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G06",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G07",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G08",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G09",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G10",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G11",false, new BigDecimal("29.99")));
        cinemaSeats.add(new Seat("G12",false, new BigDecimal("29.99")));

        cinemaSeats.add(new Seat("H01",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H02",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H03",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H04",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H05",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H06",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H07",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H08",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H09",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H10",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H11",false, new BigDecimal("32.99")));
        cinemaSeats.add(new Seat("H12",false, new BigDecimal("32.99")));

        cinemaSeats.add(new Seat("J01",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J02",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J03",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J04",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J05",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J06",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J07",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J08",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J09",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J10",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J11",false, new BigDecimal("34.99")));
        cinemaSeats.add(new Seat("J12",false, new BigDecimal("34.99")));
        cinemas.add(new Cinema("Colours", cinemaSeats));

        cinemaSeats.forEach(seat -> seatMap.put(seat.getSeatNumber(),seat));



    }

}
