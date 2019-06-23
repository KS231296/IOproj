/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryAndFacade;

/**
 *
 * @author dell
 */
import categories.TestControl;
import client.Client;
import client.Reservation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import owner.Yacht;
import testData.Data;

@Category({TestControl.class})
public class FactoryTest {
    public FactoryTest() {
    }
    
    static Data testData;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @BeforeClass
    public static void setUpClass() {
        testData = new Data();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testCreateNewClient() {
        System.out.println("createClient");
        Factory instance = new Factory();
        for (int i = 0; i < testData.clients.length; i++) {
            Client result = instance.createClient(testData.clientsData[i]);
            assertEquals(testData.clients[i], result);
        }
    }
     @Test
    public void testCreateNewYacht() {
        System.out.println("createYacht");
        Factory instance = new Factory();

        for (int i = 0; i < testData.yachts.length; i++) {
            Yacht result = instance.createYacht(testData.yachtsData[i]);
            assertEquals(testData.yachts[i], result);
        }
    }
    @Test
    public void testCreateNewReservation() {
        System.out.println("createReservation");
        Factory instance = new Factory();

        for (int i = 0; i < testData.reservations.length; i++) {
            Reservation result = instance.createReservation(testData.reservationsData[i],testData.yachts[i],testData.clients[i]);
            
            assertEquals(testData.reservations[i], result);
        }
    }
    
    
    
}
