/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categories;


import client.ClientTest;
import client.ReservationTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import owner.YachtTest;

/**
 *
 * @author dell
 */



    @Categories.SuiteClasses({ReservationTest.class, YachtTest.class,ClientTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestEntity.class)
public class EntityRun {


}

