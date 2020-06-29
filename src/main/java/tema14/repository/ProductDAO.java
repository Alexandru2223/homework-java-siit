package tema14.repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import tema14.entity.Product;

public interface ProductDAO {
    void create(Product product);
    List<Product> read(String productCode) throws SQLException;
    void update(String productCode, int updateQuantity, BigDecimal updatePrice) throws SQLException;
    void delete(String productCode);
}
