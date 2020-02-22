package se.utbildning.hala;

import org.junit.Before;
import org.junit.Test;
import se.utbildning.hala.data.CityDao;
import se.utbildning.hala.data.CityDaoJDBC;
import se.utbildning.hala.entity.City;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private CityDao dao;


    @Before
    public void setUp() throws Exception {
         dao = new CityDaoJDBC();
    }

    @Test
    public void given_findById_tests_successfully() {

        assertNotNull( dao.findById(1) );
        assertEquals(1, dao.findById(1).getCityId());
        assertTrue(dao.findById(1) != null);
    }

    @Test
    public void test_findByCode(){
        assertTrue(dao.findByCode("AFG")!= null);
        assertEquals(4,dao.findByCode("AFG").size());
        assertNotNull(dao.findByCode("AFG"));
    }

    @Test
    public void test_findByName(){
        String expected = "Karlshamn";
        String actual = dao.findByName("Karlshamn").get(0).getCityName();
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_findAll(){
        assertNotNull(dao.findAll());
        assertEquals(4082,dao.findAll().size());
    }

    @Test
    public void test_addCity(){

        City city = new City("Amsterdam","NLD","Noord-holland",731200);
        assertEquals(city,dao.add(city));
        assertNotNull(dao.add(city));
    }

    @Test
    public void test_updateCity(){
        City test = dao.findById(4080);
        test.setPopulation(32000);
        assertNotNull(dao.findById(4080));
        assertEquals(test, dao.update(test));
    }

    @Test
    public void test_delete(){
        City city = new City(4092,"Amsterdam","NLD","Noord-holland",731200);
        assertEquals(1,dao.delete(city));
        assertEquals(4081,dao.findAll().size());
    }
}
