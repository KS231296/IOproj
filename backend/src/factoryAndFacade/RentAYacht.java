package factoryAndFacade;

import client.Client;
import client.Reservation;
import java.time.LocalDate;
import owner.Yacht;

import java.util.ArrayList;

public class RentAYacht {

    public static void main(String[] args) {
//
//
//        Facade facade = new Facade ();
//        String client1[] = {"1","1", "Andy", "Anderson", "123123123"};
//        String client2[] = {"1","2", "Louis", "Anderson", "123456456"};
//
//        facade.addClient (client1);
//      facade.addClient (client2);
//        System.out.println (facade.getClients ().toString ());
//facade.deleteClient (1);
//        System.out.println (facade.getClients ().toString ());
//facade.addClient (client1);
////facade.modifyClient (1,"phone","111222333");
//        System.out.println (facade.getClients ().toString ());
//
//// Yacht(int yachtID, String name, String type, double length, int crewNumber, double enginePower, int sailsNumber)
//
//        String yacht1[] = {"1","1", "Speed Demon", "motor boat", "20", "3", "500", "0"};
//        String yacht2[] = {"1","2", "Butterfly", "sailing vessel", "50", "10", "50", "3"};
//        facade.addYacht (yacht1);
//       facade.addYacht (yacht2);
//      
//        System.out.println (facade.getYachts ().toString ());
////facade.modifyYacht (1,"name", "Wildcat");
//
//        System.out.println (facade.getYachts ().toString ());

       
Facade fac = new Facade();
  System.out.println (fac.getYachts ().toString ());
//       String yacht1[] = {"0","0", "0", "motor boat", "0", "3", "500", "0"};
//fac.addYacht(yacht1);
  System.out.println (fac.getYachts ().toString ());
        Yacht yacht = new Yacht();
        yacht.setEnginePower(20);
        yacht.setType("dodo");
      //  yacht.setName("t");
        
        Yacht yacht2 = new Yacht();
        yacht2.setEnginePower(20);
        yacht2.setType("dodo");
        yacht2.setName("huhu");
        System.out.println ( yacht.equals(yacht2));
        
       
        System.out.println (yacht);
        System.out.println ("data:\n ID: "+ yacht.getYachtID()+ ", name: "+ yacht.getName()+", sails: "+yacht.getSailsNumber());

    }
}
