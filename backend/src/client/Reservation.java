package client;

import java.time.LocalDate;

public class Reservation {


    //pola
    String client;
    private LocalDate dateStart;
     private LocalDate dateEnd;
    private int number;
    String model;

    //gettery i settery
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Reservation() {
    }

    public Reservation searchReservation(Reservation reservation) {
        // TODO - implement ModelOfYacht.compare
        throw new UnsupportedOperationException ();
    }


}
