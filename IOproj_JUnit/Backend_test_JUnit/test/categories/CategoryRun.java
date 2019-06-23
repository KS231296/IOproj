/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categories;


import factoryAndFacade.FacadeTest;
import factoryAndFacade.FactoryTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

    @Categories.SuiteClasses({FactoryTest.class, FacadeTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
public class CategoryRun {


}
