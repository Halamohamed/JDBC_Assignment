package se.utbildning.hala;

import se.utbildning.hala.data.CityDaoJDBC;
import se.utbildning.hala.data.Database;
import se.utbildning.hala.entity.City;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        //Database.getConnection();
        CityDaoJDBC dao = new CityDaoJDBC();
        //find by id
        //System.out.println(dao.findById(1));

        //find by code
        //dao.findByCode("AFG").forEach(System.out::println);

        //find by name
        //dao.findByName("Amsetrdam").forEach(System.out::println);


        City city = new City(4093,"Amsterdam", "NLD", "Noord-holland", 731200);

        //delete city
        //System.out.println(dao.delete(city));

        //find all
        //dao.findAll().forEach(System.out::println);

        //add  city
        //System.out.println(dao.add(city));

        // update city
        //city.setPopulation(32000);
        //System.out.println(dao.update(city));

        //delete city
        //System.out.println(dao.delete(city));

    }
}
