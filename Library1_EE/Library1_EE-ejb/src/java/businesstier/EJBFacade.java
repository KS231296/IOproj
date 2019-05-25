/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesstier;

import client.Client;
import client.Reservation;
import factoryAndFacade.Facade;
import factoryAndFacade.Factory;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import owner.Yacht;

/**
 *
 * @author xxx
 */
@Stateless
public class EJBFacade implements EJBFacadeRemote {

  
    Facade facade = new Facade();

    List<Client> clients;
    List<Yacht> yachts;
    List<Reservation> reservations;


    @Override
    public String addReservation(String[] data1, String[] data2, String datesofReservation[]) {
        Factory factory = new Factory();
        boolean results;
        Yacht help = factory.createYacht(data1), yacht;

        if ((yacht = searchFreeYacht(help, LocalDate.parse(datesofReservation[0]), LocalDate.parse(datesofReservation[1]))) != null) {
            Client helpclient = factory.createClient(data2), client;
            client = searchClient(helpclient);
            if (client != null) {
                client.addReservation(datesofReservation, yacht);
                reservations.add(client.addReservation(data1, yacht));
                return "Zarezerwowano jacht";
            }
            return "Brak klienta";
        }
        return "Brak wolnego jachtu";
    }

    @Override
      public Yacht searchFreeYacht(Yacht help, LocalDate date1, LocalDate dataKoncowa) {
        for (Yacht yacht : yachts) {
            if (yacht.compare(help)) {
                if (yacht.isFree(date1, dataKoncowa)) {
                    return yacht;
                }
            }
        }

        return null;
    }

    @Override
    
    public Client searchClient(Client client) {
        int index = clients.indexOf(client);
        if (index != -1) {
            client = clients.get(index);
            return client;
        }
        return null;
    }


    @Override
      public String addClient(String data[]) {
        Factory factory = new Factory ();
        Client client = factory.createClient (data);
        if (searchClient (client) == null) {
            clients.add (client);
            return client.toString ();
        }
        return null;
    }
      
      

    @Override
      public Yacht searchYacht(Yacht yacht) {
        int index = yachts.indexOf(yacht);
        if (index != -1) {
            yacht = yachts.get(index);
            return yacht;
        }
        return null;
    }


}
