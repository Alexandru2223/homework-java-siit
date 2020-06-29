package tema10.wallstreet;

import lombok.Data;

@Data
public class Transaction {

    private final Trader trader;

    private final int year;

    private final int value;
}
