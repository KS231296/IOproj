/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import categories.Test_Control;
import factoryAndFacade.Factory;
import java.util.IllegalFormatCodePointException;
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

/**
 *
 * @author uaxau
 */
@Category({Test_Control.class})
public class FactoryTest {
    
    public FactoryTest() {
    }
    static Data data;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }
    
    @Test
    public void testCreateYacht(){
        System.out.println("Create yacht");
        Factory fact = new Factory();
        
        for(int i = 0;i<data.yachtData.length;i++){
            Yacht yacht = fact.createYacht(data.yachtData[i]);
           // assertEquals(data.yachts[i],yacht);
        }
        //exception.expect(IllegalFormatCodePointException.class);
       // exception.expectMessage("Code point = 0x0");
        
    }
}
