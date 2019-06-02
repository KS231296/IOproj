/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import owner.Yacht;

/**
 *
 * @author uaxau
 */
public class Data {
    public String yachtData[][]={
        {"1","1","Blue Whale","Whale","13.4","5","56.6","2"},
        {"1","2","TARDIS","Police Box","12.3","8","96.6","3"},
        {"1","3","Bovvered","Judoon","9.6","12","75.5","0"},
        
    };
    
    public Yacht yachts[] = {
        new Yacht("1","Blue Whale","Whale",13.4,5,56.6,2),
        new Yacht("2","TARDIS","Police Box",12.3,8,96.6,3),
        new Yacht("3","Bovvered","Judoon",9.6,12,75.5,0)
    };
        
}
