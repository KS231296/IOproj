package owner;

import client.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Yacht {

    //parametry jachtu
    private String yachtID;
    private String name;
    private String type; // typ : jacht motorowy czy żaglowy
    private double length; //długość jachtu w stopach
    private int crewNumber; //ilość załogi
    private double enginePower; //moc silnika w KM
    private int sailsNumber;

    private List<Reservation> reservations;

    public Yacht(String yachtID, String name, String type, double length, int crewNumber, double enginePower, int sailsNumber) {
        this.yachtID = yachtID;
        this.name = name;
        this.type = type;
        this.length = length;
        this.crewNumber = crewNumber;
        this.enginePower = enginePower;
        this.sailsNumber = sailsNumber;
        this.reservations = new ArrayList<>();
    }

    public Yacht() {

    }

    //gettery i settery
    public String getYachtID() {
        return yachtID;
    }

    public void setYachtID(String yachtID) {
        this.yachtID = yachtID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(int crewNumber) {
        this.crewNumber = crewNumber;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getSailsNumber() {
        return sailsNumber;
    }

    public void setSailsNumber(int sailsNumber) {
        this.sailsNumber = sailsNumber;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservation.setModel(this);
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservation.setModel(this);
        reservations.remove(reservation);
    }

//metoda hash 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.type);
        return hash;
    }

    //metoda toString
    @Override
    public String toString() {
        return "Yacht{"
                + "yachtID=" + yachtID
                + ", name='" + name + '\''
                + ", type='" + type + '\''
                + ", length=" + length
                + ", crewNumber=" + crewNumber
                + ", enginePower=" + enginePower
                + ", sailsNumber=" + sailsNumber
                + '}';
    }

    //metoda porównująca jachty
    @Override
    public boolean equals(Object object) {
       
        
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Yacht other = (Yacht) object;
        if (!this.yachtID.equals(other.yachtID)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    public boolean isFree(LocalDate data1, LocalDate data2) {
        for (Reservation res : this.reservations) {
            if (!res.isFree(data1, data2)) {
                return false;
            }
        }
        return true;
    }

}
