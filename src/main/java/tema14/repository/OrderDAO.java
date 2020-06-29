package tema14.repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import tema14.entity.Order;

public interface OrderDAO {
    void create(Order order);
    List<Order> read(String orderNumber) throws SQLException;
    void update(String orderNumber,String productCode, int updateQuantity, BigDecimal updatePrice) throws SQLException;
    void delete(String orderNumber, String productCode );
}
