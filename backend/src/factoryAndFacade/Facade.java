package factoryAndFacade;

import client.Client;
import client.Reservation;
import owner.Yacht;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Facade {

    //pola
    List<Client> clients;
    List<Yacht> yachts;
    List<Reservation> reservations;

//dodac liste rezerwacji

    // konstruktor
    public Facade() {
        this.clients = new ArrayList ();
        this.yachts = new ArrayList ();
    }
    
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    //gettery i settery
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public List<Yacht> getYachts() {
        return yachts;
    }

    public void setYachts(ArrayList<Yacht> yachts) {
        this.yachts = yachts;
    }


    //metoda dodająca rezerwacje
    public String addReservation(String[] data1, String[] data2, String datesofReservation [] ) {
        Factory factory = new Factory ();
        boolean results;
        Yacht help = factory.createYacht (data1),yacht;
       
               if ((yacht = searchFreeYacht(help, LocalDate.parse(datesofReservation[0]), LocalDate.parse(datesofReservation[1]))) != null) {
                    Client helpclient = factory.createClient (data2), client;
                    client = searchClient (helpclient);
                    if (client != null) {
                       client.addReservation(datesofReservation, yacht);
                         
                        reservations.add(client.addReservation (data1,yacht));
                        return "Zarezerwowano jacht";
                    }
                    return "Brak klienta";
                }
                return "Brak wolnego jachtu";
}
    
    
         
      public Yacht searchFreeYacht(Yacht help, LocalDate date1, LocalDate dataKoncowa) {
        for (Yacht yacht : yachts) {
            if (yacht.compare(help)) {
                if (yacht.isFree(date1,dataKoncowa)) {
                    return yacht;
                }
            }
        }
        return null;
    }
     
        
    //metoda dodająca klienta DOPRACOWAC !!!
    public String addClient(String data[]) {
        Factory factory = new Factory ();
        Client client = factory.createClient (data);
        if (searchClient (client) == null) {
            clients.add (client);
            return client.toString ();
        }
        return null;
    }

    //metoda usuwająca klienta
    public void deleteClient(int clientID) {

        for (int i = 0; i < clients.size (); i++) {

            if (clients.get (i).getClientID () == clientID) {
                clients.remove (i);
                System.out.println ("Klient usunięty z bazy");
            } else {
                System.out.println ("Klient o podanym ID nie istnieje");
            }


        }


    }


    //metoda wyszukująca klienta
    public Client searchClient(Client client) {
        int index = clients.indexOf (client);
        if (index != -1) {
            client = clients.get (index);
            return client;
        }
        return null;
    }

    //metoda modyfikująca jacht
    public void modifyClient(int clientID, String modifiedParameter, String newValue) {

        for (int i = 0; i < clients.size (); i++) {


            if (clients.get (i).getClientID () == clientID) {


                if (modifiedParameter.equals ("firstName") || modifiedParameter.equals ("secondName") || modifiedParameter.equals ("phone")) {
                    switch (modifiedParameter) {
                        case "firstName":
                            clients.get (i).setFirstName (newValue);

                            break;
                        case "lastName":
                            clients.get (i).setLastName (newValue);

                            break;
                        case "phone":
                            clients.get (i).setPhone (Integer.parseInt (newValue));

                            break;

                    }

                    System.out.println ("Client " + clientID + " " + modifiedParameter + " changed");

                } else {
                    System.out.println ("Podano zły parametr");
                }


            } else {
                System.out.println ("Jacht o podanym ID nie istnieje");
            }


        }


    }


    //metoda dodająca jacht DOPRACOWAC !!!
    public String addYacht(String data[]) {
        Factory factory = new Factory ();
        Yacht yacht = factory.createYacht (data);
        if (searchYacht (yacht) == null) {
            yachts.add (yacht);
            return yacht.toString ();
        }
        return null;
    }

    //metoda usuwająca jacht
    public void deleteYacht(int yachtID) {

        for (int i = 0; i < yachts.size (); i++) {

            if (yachts.get (i).getYachtID () == yachtID) {
                yachts.remove (i);
                System.out.println ("Jacht usunięty z floty");
            } else {
                System.out.println ("Jacht o podanym ID nie istnieje");
            }


        }


    }


    //metoda wyszukująca jacht
    public Yacht searchYacht(Yacht yacht) {
        int index = yachts.indexOf (yacht);
        if (index != -1) {
            yacht = yachts.get (index);
            return yacht;
        }
        return null;
    }


    //metoda modyfikująca jacht
    public void modifyYacht(int yachtID, String modifiedParameter, String newValue) {

        for (int i = 0; i < yachts.size (); i++) {


            if (yachts.get (i).getYachtID () == yachtID) {


                if (modifiedParameter.equals ("name") || modifiedParameter.equals ("enginePower") || modifiedParameter.equals ("sailsNumber")) {
                    switch (modifiedParameter) {
                        case "name":
                            yachts.get (i).setName (newValue);

                            break;
                        case "enginePower":
                            yachts.get (i).setEnginePower (Double.valueOf (newValue));

                            break;
                        case "sailsNumber":
                            yachts.get (i).setSailsNumber (Integer.parseInt (newValue));

                            break;

                    }

                    System.out.println ("Yacht " + yachtID + " " + modifiedParameter + " changed");

                } else {
                    System.out.println ("Podano zły parametr");
                }


            } else {
                System.out.println ("Jacht o podanym ID nie istnieje");
            }


        }


    }


}