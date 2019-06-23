/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author dell
 */

import categories.TestEntity;
import client.Reservation;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import testData.Data;


@Category({TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class ClientTest {
    
    static Data data;
    static Client client;
    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0},{1},{2},{3}};
        return Arrays.asList(data1);
    }

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        client = data.clients[number1];
    }

    @After
    public void tearDown() {
    }
    
    
    @Test
    public void test1Equals(){
        System.out.println("equals");
        int j = 0;
        for (Client client : data.clients){
            if (number1 == j) {
                assertTrue(client.equals(data.clients[number1]));
            } else {
                assertFalse(client.equals(data.clients[number1]));
            }
            j++;
        }
    }
    //client.addReservation(data.reservationsData[number1],data.yachts[number1]);
    @Test
    public void test2AddReservation(){
        System.out.println("addReservation");
        
                int j = 0;
for (Client client : data.clients){
    if (number1 ==j){
        Reservation res = data.reservations[j];
            client.addReservation(data.reservationsData[j],data.yachts[j]);
            assertEquals(res, client.getReservations().get(0)); //k.1.3
            assertEquals(res.getModel(), data.yachts[j]); //k.1.3
    }
            
j++;         
}
    }
}
