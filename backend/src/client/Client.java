package client;

import factoryAndFacade.Factory;
import owner.Yacht;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    //pola
    private String clientID;
    private String firstName;
    private String lastName;
    private String phone;
    private List<Reservation> reservations;

    //konstruktor
    public Client(String clientID, String firstName, String lastName, String phone) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.reservations = new ArrayList<> ();
    }

    public Client() {
    }

    //gettery i settery
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.clientID, other.clientID)) {
            return false;
        }
        return true;
    }

 public void   addReservation(String data[],Yacht yacht)
 {
     Factory factory=new Factory();
     Reservation res=factory.createReservation(data, yacht, this);
     if(!reservations.contains(res)){
         reservations.add(res);
     }
 }
 
 public void cancelReservation(String data[],Yacht yacht){
     Factory factory = new Factory();
     Reservation res = factory.createReservation(data,yacht,this);
     int index = reservations.indexOf(res);
     
     
     if(index != -1){
         res = reservations.get(index);
         reservations.remove(res);
     }
     
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

    public Reservation insideReservation(Reservation reservation){
        int index = reservations.indexOf(reservation);
        Reservation resHelp = null;
        if(index != -1){
            resHelp = reservations.get(index);
        }
        return resHelp;
    }
    
    public boolean findReservation(String[] dataOfRes, Yacht yacht){
        Factory factory = new Factory();
        Reservation resHelp = factory.createReservation(dataOfRes, yacht, this);
        int index = reservations.indexOf(resHelp);
        if(index != -1){
            return true;
        }
        return false;
    }
}
     
     
     
     
     


