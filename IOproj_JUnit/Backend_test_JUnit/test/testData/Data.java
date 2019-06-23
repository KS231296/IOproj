/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testData;

import client.Client;
import client.Reservation;
import java.time.LocalDate;
import owner.Yacht;



public class Data {

    public String[][] clientsData = {
        {"1","1", "Adam", "Mickiewicz", "123123123"},
        {"1","2", "Wisława", "Szymborska", "123123123"},
        {"1","3", "Ala", "Makota", "123456456"},
        {"1","4", "Mieszko","Pierwszy", "123456456"}
    };
    
    public String[][] clientsData2 = {
        {"1", "Adam", "Mickiewicz", "123123123"},
        {"2", "Wisława", "Szymborska", "123123123"},
        {"3", "Ala", "Makota", "123456456"},
        {"4", "Mieszko","Pierwszy", "123456456"}
    };
    

    public Client[] clients = {
        new Client(clientsData2[0]),
        new Client(clientsData2[1]),
        new Client(clientsData2[2]),
        new Client(clientsData2[3])};
    
    
    
    
    public String[][] yachtsData = {
        {"1","1", "Speed Demon", "motor boat", "20", "3", "500", "0"},
        {"1","2", "Devil", "motor boat", "10", "2", "350", "3"},
        {"1","3", "Butterfly", "sailing vessel", "50", "10", "50", "6"},
        {"1","4", "Speedy", "motor boat", "15", "3", "400", "9"},
        {"1","5", "Moon", "sailing vessel", "30", "7", "50", "12"},
        {"1","6", "Seal", "sailing vessel", "70", "13", "50", "15"}};
    
    
    public String[][] yachtsData2 = {
        {"1", "Speed Demon", "motor boat", "20", "3", "500", "0"},
        {"2", "Devil", "motor boat", "10", "2", "350", "3"},
        {"3", "Butterfly", "sailing vessel", "50", "10", "50", "6"},
        {"4", "Speedy", "motor boat", "15", "3", "400", "9"},
        {"5", "Moon", "sailing vessel", "30", "7", "50", "12"},
        {"6", "Seal", "sailing vessel", "70", "13", "50", "15"}};
    
    public Yacht[] yachts = {
        new Yacht(yachtsData2[0]),
        new Yacht(yachtsData2[1]),
        new Yacht(yachtsData2[2]),
        new Yacht(yachtsData2[3]),
        };
    
    
    
    // typ tworzenia, numer, data data
    public String[][] reservationsData ={
        {"1","1","2019-07-15","2019-07-21"},
        {"1","2","2019-07-08","2019-07-14"},
        {"1","3","2019-07-22","2019-07-28"},
        {"1","4","2019-07-13","2019-07-15"}
    };
    
    
    public String[][] reservationsData2 ={
        {"2019-07-15","2019-07-21","1"},
        {"2019-07-08","2019-07-14","2"},
        {"2019-07-22","2019-07-28","3"},
        {"2019-07-13","2019-07-15","4"}
    };
    
    
    
    //public Reservation(String[] string, Yacht model, Client client) // data, data numer
    public Reservation[] reservations={
        
        new Reservation(reservationsData2[0],yachts[0],clients[0]),
        new Reservation(reservationsData2[1],yachts[1],clients[1]),
        new Reservation(reservationsData2[2],yachts[2],clients[2]),
        new Reservation(reservationsData2[3],yachts[3],clients[3]),
        
    };
            
   
    public LocalDate[]dates1={
        LocalDate.parse("2019-07-15"),
        LocalDate.parse("2019-07-08"),
        LocalDate.parse("2019-07-22"),
        LocalDate.parse("2019-07-13"),
        LocalDate.parse("2019-08-13")
            
    
    };
     public LocalDate[] dates2={
        LocalDate.parse("2019-07-21"),
        LocalDate.parse("2019-07-14"),
        LocalDate.parse("2019-07-28"),
        LocalDate.parse("2019-07-15"),
        LocalDate.parse("2019-08-15")
            
    
    };
    
    
}
