package client;

import owner.Yacht;
import factoryAndFacade.Factory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    //pola
    private int clientID;
    private String firstName;
    private String lastName;
    private int phone;
    private List<Reservation> reservations;

    //konstruktor
    public Client(int clientID, String firstName, String lastName, int phone) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.reservations = new ArrayList<> ();
    }

    public Client() {
    }

    //gettery i settery
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    //metody

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass () != object.getClass ()) {
            return false;
        }
        final Client other = (Client) object;
        if (!Objects.equals (this.clientID, other.clientID)) {
            return false;
        }
        return true;
    }

    //metoda hash
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode (this.clientID);
        hash = 11 * hash + Objects.hashCode (this.firstName);
        hash = 11 * hash + Objects.hashCode (this.lastName);
        hash = 11 * hash + Objects.hashCode (this.reservations);
        return hash;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Client{" +
//                "clientID=" + clientID +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phone=" + phone +
//                ", reservations=" + reservations +
//                '}';
//    }


    //metoda dodająca rezerwacje
     public void addReservation(String[] data, Yacht yacht, Client client)  {
          Factory factory = new Factory();
        Reservation reservation = factory.createReservation(data, yacht, client);
        reservation.setClient(this);
        reservations.add(reservation);
       yacht.addReservation(reservation); 
    }
     
     
     
     
     
    public void removeReservation(String[] data, Yacht yacht, Client client) { 
        Factory factory = new Factory();
        Reservation reservation = factory.createReservation(data, yacht, client);
        reservation.setClient(this);
        reservations.remove(reservation);
        yacht.removeReservation(reservation); 
    }
    
 
     
}
     
     
     
     
     


