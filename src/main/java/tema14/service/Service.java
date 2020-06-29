package tema14.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import lombok.AllArgsConstructor;
import tema14.entity.Order;
import tema14.entity.Product;
import tema14.repository.OrderDAO;
import tema14.repository.ProductDAO;

@AllArgsConstructor
public class Service {
    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;
    public List<Product> readProduct(String productCode) throws SQLException {
        return productDAO.read(productCode);
    }

    public void updateProduct(String productCode, int updateQuantity, BigDecimal updatePrice) throws SQLException {
        productDAO.update(productCode,updateQuantity,updatePrice);
    }

    public void deleteProduct(String productCode){
        productDAO.delete(productCode);
    }
    public void createProduct(Product product){
        productDAO.create(product);
    }

    public List<Order> readOrder(String orderCode) throws SQLException {
        return orderDAO.read(orderCode);
    }
    public void updateOrder(String orderNumber,String productCode, int updateQuantity, BigDecimal updatePrice) throws SQLException {
        orderDAO.update(orderNumber,productCode,updateQuantity,updatePrice);
    }
    public void deleteOrder(String orderNumber, String productCode){
        orderDAO.delete(orderNumber,productCode);
    }
    public void createOrder(Order order){
        orderDAO.create(order);
    }

   /* public static void main(String[] args) throws SQLException {
        Service service = new Service(new ProductDAOImpl(), new OrderDAOImpl());
   //     Service serviceOrder = new Service(new OrderDAOImpl());
       // System.out.println(service.read("S10_1949"));
       // service.update("S10_1949", 1050, new BigDecimal(150));
       // service.delete("S10_2016");
        Product product = new Product().builder()
                                       .productCode("S10_1949")
                                       .productName("1234")
                                       .productLine("Trains")
                                       .productScale("1:18")
                                       .productVendor("ASDF")
                                       .productDescription("A B C D E")
                                       .quantityInStock(1000)
                                       .buyPrice(new BigDecimal("192.3"))
                                       .MSRP(50.5)
                                       .build();
       //service.create(product);

        System.out.println(service.readProduct("S10_1949"));
        service.updateOrder("10100", "S18_1749", 500, new BigDecimal("300"));
       // service.deleteOrder("10100", "S18_2248");
        service.createOrder(new Order("10100", "S18_2248",1000,new BigDecimal("150"),4));
        List<Order> orderList = service.readOrder("10100");
        orderList.forEach(order -> System.out.println(order));
    }*/
}
