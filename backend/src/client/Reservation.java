package client;

import java.time.LocalDate;

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

    public Reservation searchReservation(Reservation reservation) {
        // TODO - implement ModelOfYacht.compare
        throw new UnsupportedOperationException ();
    }


}
