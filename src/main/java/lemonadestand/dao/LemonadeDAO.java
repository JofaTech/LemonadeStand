package lemonadestand.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lemonadestand.entity.Lemonade;

public class LemonadeDAO {

	public LemonadeDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
		}
	}

	private Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "bondstone");
	}

	public Lemonade createLemonade(Lemonade lemonade) {

		try (PreparedStatement createLemonadeStatement = getDBConnection().prepareStatement(
				"INSERT INTO lemonade (\"lemonJuice\", water, \"iceCubes\", sugar, price, order_id) VALUES (?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);) {
			createLemonadeStatement.setDouble(1, lemonade.getLemonJuice());
			createLemonadeStatement.setDouble(2, lemonade.getWater());
			createLemonadeStatement.setInt(3, lemonade.getIceCubes());
			createLemonadeStatement.setDouble(4, lemonade.getSugar());
			createLemonadeStatement.setDouble(5, lemonade.getPrice());
			createLemonadeStatement.setInt(6, lemonade.getOrder().getId());
			int created = createLemonadeStatement.executeUpdate();
			if (created == 0) {
				throw new SQLException();
			}
			ResultSet resultSet = createLemonadeStatement.getGeneratedKeys();
			if (resultSet.next()) {
				return new Lemonade(resultSet.getInt(1), lemonade.getLemonJuice(), lemonade.getPrice(),
						lemonade.getSugar(), lemonade.getIceCubes(), lemonade.getWater(), lemonade.getOrder());
			} else {
				throw new SQLException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to create lemonade.");
		}

		return null;
	}

}
