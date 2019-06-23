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
public class ReservationTest {
    
    
    static Data data;
    static Reservation res;
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
        res = data.reservations[number1];
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Equals(){
        System.out.println("equals");
        int j = 0;
        for (Reservation res : data.reservations){
            if (number1 == j) {
                assertTrue(res.equals(data.reservations[number1]));
            } else {
                assertFalse(res.equals(data.reservations[number1]));
            }
            j++;
        }
    }
    
    @Test
    public void test3IsFree(){
        System.out.println("isFree");
        boolean result = true;
        result=res.isFree(data.dates1[number1],data.dates2[number1]);
        assertFalse(result);
        result=res.isFree(data.dates1[4],data.dates2[4]);
        assertTrue(result);
    }
}
