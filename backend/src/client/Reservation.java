package client;


import java.time.LocalDate;
import owner.Yacht;

public class Reservation {


    //pola
    Client client;
    private LocalDate dateStart;
     private LocalDate dateEnd;
    private int number;
    Yacht model;

    //gettery i settery
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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

    public Yacht getModel() {
        return model;
    }

    public void setModel(Yacht model) {
        this.model = model;
    }


    public Reservation() {
    }

  


}
