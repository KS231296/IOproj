package client;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {


    //pola
    int clientID;
    private LocalDate dateStart;
     private LocalDate dateEnd;
    private int number;
    int modelID;

    //gettery i settery
    public int getClient() {
        return clientID;
    }

    public void setClient(int client) {
        this.clientID = client;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

 

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getModel() {
        return modelID;
    }

    public void setModel(int model) {
        this.modelID = model;
    }


    public Reservation() {
    }

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
        final Reservation other = (Reservation) object;
        if (this.number != other.number) {
            return false;
        }
       
        return true;
    }
    

}
