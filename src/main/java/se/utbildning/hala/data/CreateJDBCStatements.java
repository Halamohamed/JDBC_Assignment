package se.utbildning.hala.data;

import se.utbildning.hala.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateJDBCStatements {
    private static final String FIND_BY_ID =
            "SELECT * FROM city WHERE id = ?";
    private static final String FIND_BY_CODE =
            "SELECT * FROM city WHERE CountryCode = ?";
    private static final String FIND_BY_NAME =
            "SELECT * FROM city WHERE Name = ?";
    private static final String FIND_ALL =
            "SELECT * FROM city ";
    private static final String INSERT =
            "INSERT INTO city(Name,CountryCode,District,Population) VALUES (?,?,?,?) ";
    private static final String UPDATE =
            "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ?  WHERE ID = ?";



    public static PreparedStatement create_findById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        return statement;
    }

    public static PreparedStatement create_findByCode(Connection connection, String code) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_CODE);
        statement.setString(1,code);
        return statement;
    }

    public static PreparedStatement create_findByName(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
        statement.setString(1,name);
        return statement;
    }

    public static PreparedStatement create_findAll(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_ALL);
        return statement;
    }

    public static PreparedStatement create_add(Connection connection, City city) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,city.getCityName());
        statement.setString(2,city.getCityCode());
        statement.setString(3,city.getDistrict());
        statement.setInt(4,city.getPopulation());
        statement.execute();
        return statement;
    }

    public static PreparedStatement create_update(Connection connection,City city) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1,city.getCityName());
        statement.setString(2,city.getCityCode());
        statement.setString(3,city.getDistrict());
        statement.setInt(4,city.getPopulation());
        statement.setInt(5,city.getCityId());
        statement.execute();
        return statement;
    }
}
