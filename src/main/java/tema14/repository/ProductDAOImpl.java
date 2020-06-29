package tema14.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tema14.entity.Product;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void create(Product product) {
        String query = "INSERT INTO products( productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) VALUES (?, ?, ?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
            preparedStatement.setBigDecimal(8, product.getBuyPrice());
            preparedStatement.setDouble(9, product.getMSRP());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
              System.out.println("Error while creating new product");
        }
        if (rowsAffected > 0) {
            System.out.println("Product " + product.getProductCode() + " succesfully created");
        }
    }

    @Override
    public List<Product> read(String productCode) {
        String query = "select * from products where productCode = ?";
        List<Product> productList = new ArrayList();
        PreparedStatement ps = getPreparedStatement(query);

        try {
            ps.setString(1, productCode);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            Product product = extractProductFromResultSet(resultSet);
            productList.add(product);
        } catch (SQLException e) {
            System.out.println("Error while retrieving product with product code: " + productCode);
        }
        return productList;
    }

    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        return Product.builder()
                      .productCode(rs.getString("productCode"))
                      .productName(rs.getString("productName"))
                      .productLine(rs.getString("productLine"))
                      .productScale(rs.getString("productScale"))
                      .productVendor(rs.getString("productVendor"))
                      .productDescription(rs.getString("productDescription"))
                      .quantityInStock(rs.getInt("quantityInStock"))
                      .buyPrice(rs.getBigDecimal("buyPrice"))
                      .MSRP(rs.getDouble("MSRP"))
                      .build();
    }

    @Override
    public void update(String productCode, int updateQuantity, BigDecimal updatePrice) {
        String query = "UPDATE products SET quantityInStock = ?,buyPrice = ? where productCode = ?";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setInt(1, updateQuantity);
            preparedStatement.setBigDecimal(2, updatePrice);
            preparedStatement.setString(3, productCode);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating order");
        }
        if (rowsAffected > 0) {
            System.out.println("Product with code " + productCode + " has been succesfully updated");
        }


    }

    @Override
    public void delete(String productCode) {
        String query = "delete from products where productCode = ?";
        PreparedStatement preparedStatement = getPreparedStatement(query);
        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, productCode);
            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error while deleting product with code " + productCode);
        }
        if (rowsAffected > 0) {
            System.out.println("Product with code " + productCode + " was succesfully deleted");
        }
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
}
