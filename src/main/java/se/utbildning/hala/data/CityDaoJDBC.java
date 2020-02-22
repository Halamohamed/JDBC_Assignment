package se.utbildning.hala.data;

import se.utbildning.hala.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static se.utbildning.hala.data.Database.getConnection;

public class CityDaoJDBC implements CityDao {
    private static final String INSERT =
            "INSERT INTO city(Name,CountryCode,District,Population) VALUES (?,?,?,?) ";
    private static final String DELETE =
            "DELETE FROM city WHERE id = ?";
    private static final String UPDATE =
            "UPDATE city SET name = ?, countryCode = ?, district = ?, population = ?  WHERE id = ?";


    @Override
    public City findById(int id) {
        City city = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = CreateJDBCStatements.create_findById(connection,id);
                ResultSet resultSet = statement.executeQuery()
                ){
            while (resultSet.next()){
                city = new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                        );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = CreateJDBCStatements.create_findByCode(connection,code);
                ResultSet resultSet = statement.executeQuery()
                ){
            while (resultSet.next()){
                cities.add(new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = CreateJDBCStatements.create_findByName(connection,name);
                ResultSet resultSet = statement.executeQuery()
        ){
            while (resultSet.next()){
                cities.add(new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;

    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = CreateJDBCStatements.create_findAll(connection);
                ResultSet resultSet = statement.executeQuery()
        ){
            while (resultSet.next()){
                cities.add(new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City add(City city) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

                ){
            statement.setString(1,city.getCityName());
            statement.setString(2,city.getCityCode());
            statement.setString(3,city.getDistrict());
            statement.setInt(4,city.getPopulation());
            statement.execute();


            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return city;
    }

    @Override
    public City update(City city) {
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE);
                ) {
            statement.setString(1,city.getCityName());
            statement.setString(2,city.getCityCode());
            statement.setString(3,city.getDistrict());
            statement.setInt(4,city.getPopulation());
            statement.setInt(5,city.getCityId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public int delete(City city) {
        int noDeletet = 0;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE)
                ){
            statement.setInt(1,city.getCityId());
            noDeletet = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return noDeletet;
    }
}
