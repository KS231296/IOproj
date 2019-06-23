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

    // konstruktor
    public Facade() {
        this.clients = new ArrayList();
        this.yachts = new ArrayList();
    }

    public List<Client> getClients() {
        return clients;
    }

    public String[] getClientsData() {
        String[] data = new String[clients.size()];
        for (int i = 0; i < clients.size(); i++) {
            data[i] = clients.get(i).toString();
        }
        return data;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public List<Yacht> getYachts() {
        return yachts;
    }

    public String[] getYachtsData() {
        String[] data = new String[yachts.size()];
        for (int i = 0; i < yachts.size(); i++) {
            data[i] = yachts.get(i).toString();
        }
        return data;
    }
    
        public String[] getClientReservationsData(String clientID){
        List<Reservation> res = new ArrayList<>();
        for (Client client : clients) {
            if (client.getClientID().equals(clientID)) {
                res.addAll(client.getReservations());
                
            }
        }

            
        String[] data = new String[res.size()];
        for(int i = 0; i < res.size();i++){
            data[i] = res.get(i).toString();
        }
        return data;
    }

    public void setYachts(ArrayList<Yacht> yachts) {
        this.yachts = yachts;
    }
        

  
    
    public String[] getReservationsData(){
        List<Reservation> res = new ArrayList<>();
        for(int i = 0; i < clients.size(); i++){
            if(!clients.get(i).getReservations().isEmpty()){
                res.addAll(clients.get(i).getReservations());
            }
        }
        String[] data = new String[res.size()];
        for(int i = 0; i < res.size();i++){
            data[i] = res.get(i).toString();
        }
        return data;
    }

   

    //metoda dodająca rezerwacje
       public String addReservation(String[] dataOfClient, String[] datayacht, String datesofReservation[]) {
        Factory factory = new Factory();
        Yacht yacht = factory.createYacht(datayacht);
        yacht = insideYacht(yacht);
        if (yacht == null) {
            return "Brak jachtu";
        }
        Client client = factory.createClient(dataOfClient);
        client = insideClient(client);
        if (client == null) {
            return "Brak klienta";
        }
        if ((yacht.isFree(LocalDate.parse(datesofReservation[2]), LocalDate.parse(datesofReservation[3])))) {
            client.addReservation(datesofReservation, yacht);
            return "Zarezerwowano jacht";
        }
        return "Brak wolnego jachtu";

    }
    public String addClient(String data[]) {
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        if (insideClient(client) == null) {
            clients.add(client);
            return client.toString();
        }
        return null;
    }

    public void deleteClient(String clientID) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientID() == clientID) {
                clients.remove(i);
                System.out.println("Klient usunięty z bazy");
            } else {
                System.out.println("Klient o podanym ID nie istnieje");
            }
        }
    }

    //metoda modyfikująca jacht
    public void modifyClient(String modifiedParameter, String[] newValue) {
        String[] dataForFinding = {newValue[0], newValue[1]};
        Factory factory = new Factory();
        Client client = insideClient(factory.createClient(dataForFinding));
        if (modifiedParameter.equals("firstName") || modifiedParameter.equals("secondName") || modifiedParameter.equals("phone")) {
            switch (modifiedParameter) {
                case "firstName":
                    client.setFirstName(newValue[2]);
                    break;

                case "lastName":
                    client.setLastName(newValue[3]);
                    break;

                case "phone":
                    client.setPhone(newValue[4]);
                    break;

            }

            System.out.println("Client " + newValue[1] + " " + modifiedParameter + " changed");

        } else {
            System.out.println("Podano zły parametr");
        }
    }

    //metoda dodająca jacht DOPRACOWAC !!!
    public String addYacht(String data[]) {
        Factory factory = new Factory();
        Yacht yacht = factory.createYacht(data);
        if (insideYacht(yacht) == null) {
            yachts.add(yacht);
            return yacht.toString();
        }
        return null;
    }

    //metoda usuwająca jacht
    public void deleteYacht(String yachtID) {
        for (int i = 0; i < yachts.size(); i++) {

            if (yachts.get(i).getYachtID().equals(yachtID)) {
                yachts.remove(i);
                System.out.println("Jacht usunięty z floty");
            } else {
                System.out.println("Jacht o podanym ID nie istnieje");
            }

        }

    }

     public String[] searchYachts(String[] data) {
        Factory factory = new Factory();
        Yacht yacht = factory.createYacht(data);
        ArrayList<String> ff = new ArrayList();
        for (int i = 0; i < yachts.size(); i++) {
            if (yacht.compare(yachts.get(i))) {
                ff.add(yachts.get(i).toString());
            }
        }
        String[] d = new String[ff.size()];
        return ff.toArray(d);
    }

    public String[] searchClients(String[] data) {
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        ArrayList<String> ff = new ArrayList();
        for (int i = 0; i < clients.size(); i++) {
            if (client.equals(clients.get(i))) {
                ff.add(clients.get(i).toString());
                System.out.println("add" + i);
            }
        }
        String[] d = new String[ff.size()];
        return ff.toArray(d);
    }

    //metoda modyfikująca jacht
    public boolean modifyYacht(String modifiedParameter, String[] data) {
        String yachtID = data[0];
        boolean changed = false;
        for (int i = 0; i < yachts.size(); i++) {
            if (yachts.get(i).getYachtID().equals(yachtID)) {
                 changed = true;
                switch (modifiedParameter) {
                    case "name":
                        yachts.get(i).setName(data[1]);

                        break;
                    case "enginePower":
                        yachts.get(i).setEnginePower(Double.valueOf(data[1]));

                        break;
                    case "sailsNumber":
                        yachts.get(i).setSailsNumber(Integer.parseInt(data[1]));
                        break;
                    default:
                        changed = false;
                        System.out.println("Podano zły parametr");
                }
                if (changed) {
                    System.out.println("Yacht " + yachtID + " " + modifiedParameter + " changed");
                }
            } else {
                System.out.println("Jacht o podanym ID nie istnieje");
            }
        }
        return changed;
    }

    public Client insideClient(Client client) {
        int index = clients.indexOf(client);
        Client clientHelp = null;
        if (index != -1) {
            clientHelp = clients.get(index);
        }
        return clientHelp;
    }

    public Yacht insideYacht(Yacht yacht) {
        int index = yachts.indexOf(yacht);
        Yacht yachtHelp = null;
        if (index != -1) {
            yachtHelp = yachts.get(index);
        }
        return yachtHelp;
    }

    public String searchYacht(String[] yachtData) {
        Factory factory = new Factory();
        int index = yachts.indexOf(factory.createYacht(yachtData));
        Yacht yachtHelp;
        if (index != -1) {
            yachtHelp = yachts.get(index);
            return yachtHelp.toString();
        }
        return "No such yacht";
    }

    public String searchClient(String[] clientData) {
        Factory factory = new Factory();
        int index = clients.indexOf(factory.createClient(clientData));
        Client clientHelp;
        if (index != -1) {
            clientHelp = clients.get(index);
            return clientHelp.toString();
        }
        return "No such Client";
    }
}