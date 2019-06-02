package client;


import java.time.LocalDate;
import owner.Yacht;

public class Reservation {
    public Reservation(Client client, LocalDate dateStart, LocalDate dateEnd, int number, Yacht model) {
        this.client = client;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.number = number;
        this.model = model;
    }
     public Reservation() {
    }



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

    
    
     public boolean isFree(LocalDate data1_, LocalDate data2_)
   {
      return  getDateStart().isAfter(data2_) || getDateEnd().isBefore(data1_); 
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.number;
        return hash;
    }

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
        final Reservation other = (Reservation) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }
    

   
  


}
