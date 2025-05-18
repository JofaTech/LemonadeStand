package lemonadestand.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lemonadestand.entity.Customer;

public class CustomerDAO {

	public CustomerDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
		}
	}

	private Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "bondstone");
	}

	public Customer createCustomer(Customer customer) {

		try (PreparedStatement createCustomerStatement = getDBConnection().prepareStatement(
				"INSERT INTO customer (name, \"phoneNumber\") VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
			createCustomerStatement.setString(1, customer.getName());
			createCustomerStatement.setString(2, customer.getPhoneNumber());
			int created = createCustomerStatement.executeUpdate();
			if (created == 0) {
				throw new SQLException();
			}
			ResultSet resultSet = createCustomerStatement.getGeneratedKeys();
			if (resultSet.next()) {
				return new Customer(resultSet.getInt(1), customer.getName(), customer.getPhoneNumber());
			} else {
				throw new SQLException();
			}

		} catch (SQLException e) {
			System.out.println("Unable to create new customer.");
		}

		return null;
	}
}
