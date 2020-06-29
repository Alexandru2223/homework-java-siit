package tema14.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tema14.entity.Order;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void create(Order order) {
        String query = "INSERT INTO orderdetails( orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) VALUES (?, ?, ?,?,?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, order.getOrderNumber());
            preparedStatement.setString(2, order.getProductCode());
            preparedStatement.setInt(3, order.getQuantityOrdered());
            preparedStatement.setBigDecimal(4, order.getPriceEach());
            preparedStatement.setInt(5, order.getOrderLineNumber());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while creating new order");
        }
        if (rowsAffected > 0) {
            System.out.println("Order " + order.getOrderNumber() + " succesfully created");
        }
    }

    @Override
    public List<Order> read(String orderNumber) throws SQLException {
        String query = "select * from orderdetails where orderNumber = ?";
        List<Order> orderList = new ArrayList();
        PreparedStatement ps = getPreparedStatement(query);

        try {

            ps.setString(1, orderNumber);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order product = extractOrderFromResultSet(resultSet);
                orderList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving product with product code: " + orderNumber);
        }
        return orderList;
    }

    private PreparedStatement getPreparedStatement(String query) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=EET",
                    "root",
                    "12345678");
            return connection.prepareStatement(query);
        } catch (SQLException throwable) {
            System.out.println("Error while getting connection");
            throw new RuntimeException("Error while getting connection", throwable);
        }
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return Order.builder()
                    .orderNumber(rs.getString("orderNumber"))
                    .productCode(rs.getString("productCode"))
                    .quantityOrdered(rs.getInt("quantityOrdered"))
                    .priceEach(rs.getBigDecimal("priceEach"))
                    .orderLineNumber(rs.getInt("orderLineNumber"))
                    .build();
    }

    @Override
    public void update(String orderNumber, String productCode, int updateQuantity, BigDecimal updatePrice) throws SQLException {
        String query = "UPDATE orderdetails SET quantityOrdered = ?,priceEach = ? where orderNumber = ? and productCode = ?";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setInt(1, updateQuantity);
            preparedStatement.setBigDecimal(2, updatePrice);
            preparedStatement.setString(3, orderNumber);
            preparedStatement.setString(4, productCode);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating order");
        }
        if (rowsAffected > 0) {
            System.out.println("Order with code " + orderNumber + " has been succesfully updated");
        }
    }

    @Override
    public void delete(String orderNumber, String productCode) {
        String query = "delete from orderdetails where orderNumber = ? and productCode = ?";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, orderNumber);
            preparedStatement.setString(2, productCode);
            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error while deleting order with number " + orderNumber + " and product code " + productCode );
        }
        if (rowsAffected > 0) {
            System.out.println("Order with number " + orderNumber + " and product code " + productCode + " was succesfully deleted");
        }
    }
}
