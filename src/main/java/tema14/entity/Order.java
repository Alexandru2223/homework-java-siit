package tema14.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private int orderLineNumber;


}
