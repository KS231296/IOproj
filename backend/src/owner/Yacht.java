package owner;

import client.Reservation;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Yacht implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //parametry jachtu
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id
    ) {
        this.id = id;
    }
    
    @OneToMany(mappedBy = "yacht", cascade = ALL)
    List<Yacht> yachts;
    public List<Yacht> getYachts() {
       
        return yachts;
    }
    public void setYachts(List<Yacht> yachts) {
        this.yachts = yachts;
    }
    public Yacht(){
        yachts = new ArrayList<>();
   }

    
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
    
    public boolean compare(Yacht comparedYacht) {
        if (this.crewNumber != 0) {
            if (this.crewNumber != comparedYacht.crewNumber) {
                return false;
            }
        }
        if (this.enginePower != 0) {
            if (this.enginePower != comparedYacht.enginePower) {
                return false;
            }
        }
        if (this.length != 0) {
            if (this.length != comparedYacht.length) {
                return false;
            }
        }
        if (this.type != null ) {
            if (!this.type.equals("") && !this.type.equals(comparedYacht.type)) {
                return false;
            }
        }
        if (this.name != null ) {
            if (!this.name.equals("") && !this.name.equals(comparedYacht.name)) {
                return false;
            }
        }
        if (this.sailsNumber != 0) {
            if (this.sailsNumber != comparedYacht.sailsNumber) {
                return false;
            }
        }
        if (this.yachtID != null) {
            if (!this.yachtID.equals("") &&!this.yachtID.equals(comparedYacht.yachtID)) {
                return false;
            }
        }
        return true;
}
    
    
    
    

}
