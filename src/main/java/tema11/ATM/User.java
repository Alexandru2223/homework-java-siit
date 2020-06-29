package tema11.ATM;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private Card card;
}
