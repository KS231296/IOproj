package factoryAndFacade;

import client.Client;
import client.Reservation;
import owner.Yacht;

import java.util.ArrayList;

public class RentAYacht {
    public static void main(String[] args) {


        Facade facade = new Facade ();
        String client1[] = {"1","1", "Andy", "Anderson", "123123123"};
        String client2[] = {"1","2", "Louis", "Anderson", "123456456"};

        facade.addClient (client1);
      facade.addClient (client2);
        System.out.println (facade.getClients ().toString ());
facade.deleteClient (1);
        System.out.println (facade.getClients ().toString ());
facade.addClient (client1);
facade.modifyClient (1,"phone","111222333");
        System.out.println (facade.getClients ().toString ());

// Yacht(int yachtID, String name, String type, double length, int crewNumber, double enginePower, int sailsNumber)

        String yacht1[] = {"1","1", "Speed Demon", "motor boat", "20", "3", "500", "0"};
        String yacht2[] = {"1","2", "Butterfly", "sailing vessel", "50", "10", "50", "3"};
        facade.addYacht (yacht1);
       facade.addYacht (yacht2);

        System.out.println (facade.getYachts ().toString ());
facade.modifyYacht (1,"name", "Wildcat");

        System.out.println (facade.getYachts ().toString ());





    }
}
