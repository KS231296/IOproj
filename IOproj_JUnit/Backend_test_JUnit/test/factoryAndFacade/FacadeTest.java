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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import owner.Yacht;
import testData.Data;


@Category({TestControl.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacadeTest {
    static Data data;
    static Facade instance;
    
     public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new Facade();
        data = new Data();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    
    @Test
    public void test1AddClient() {
        System.out.println("addClient");
        for (int i = 0; i < data.clients.length; i++) {
            int number1 = instance.getClients().size();
            instance.addClient(data.clientsData[i]);
            int number2 = instance.getClients().size();
            Client result = instance.getClients().get(i);
            assertEquals(data.clients[i], result);
            assertEquals(number1, number2 - 1);
        }
    }
    
    @Test
    public void test2AddYacht() {
        System.out.println("addYacht");
        for (int i = 0; i < data.yachts.length; i++) {

            int number1 = instance.getYachts().size();
            instance.addYacht(data.yachtsData[i]);
            int number2 = instance.getYachts().size();
            Yacht result = instance.getYachts().get(number2 - 1);
            assertEquals(data.yachts[i], result);
            assertEquals(number1, number2 - 1);

        }
    }
    
    @Test
    public void test3AddReservation() {
        System.out.println("addReservation");
        for (int i = 0; i < data.reservations.length; i++) {
            int number1 = instance.getClients().get(i).getReservations().size();
            instance.addReservation(data.clientsData[i], data.yachtsData[i],data.reservationsData[i]);
            int number2 = instance.getClients().get(i).getReservations().size();
            Reservation result = instance.getClients().get(i).getReservations().get(number2 - 1);
            assertEquals(data.reservations[i], result);
            assertEquals(number1, number2 - 1);
        }
    }
    
    @Test
    public void test4InsideClient() {
            System.out.println("insideClient");
            for (int i = 0; i<data.clients.length; i++){
            Client client = instance.insideClient(data.clients[i]);
            assertEquals(client, data.clients[i]);
        }
        }
        
        @Test
    public void test5InsideYacht() {
            System.out.println("insideYacht");
            for (int i = 0; i<data.yachts.length; i++){
            Yacht yacht = instance.insideYacht(data.yachts[i]);
            assertEquals(yacht, data.yachts[i]);
        }
        }

    
}
