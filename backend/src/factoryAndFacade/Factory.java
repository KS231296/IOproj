package factoryAndFacade;

import client.Client;
import client.Reservation;
import owner.Yacht;

import java.time.LocalDate;

public class Factory {

    public Client createClient(String data[]) {
        Client client = null;

        switch (Integer.parseInt(data[0])) {
            case 0:
                client = new Client();
                client.setClientID(Integer.parseInt(data[1])); //zmeinic typ w klasie Client
                break;
            case 1:
                client = new Client(Integer.parseInt(data[1]), data[2], data[3], Integer.parseInt(data[4]));
                break;
        }
        return client;
    }

    public Reservation createReservation(String data[]) {
        Reservation reservation = null;

        switch (Integer.parseInt(data[0])) {
            case 0:
                reservation = new Reservation();
                reservation.setNumber(Integer.valueOf(data[1]));
                break;
            case 1:
                reservation = new Reservation();
                reservation.setNumber(Integer.valueOf(data[1]));
                reservation.setClient(Integer.valueOf(data[2]));
                reservation.setDateStart(LocalDate.parse(data[3]));
                reservation.setDateEnd(LocalDate.parse(data[4]));
                reservation.setModel(Integer.valueOf(data[5]));
                break;
        }
        return reservation;
    }

    public Yacht createYacht(String[] data) {

        Yacht yacht = null;

        switch (Integer.parseInt(data[0])) {
            case 0:
                yacht = new Yacht();
                yacht.setYachtID((Integer.parseInt(data[1])));

                break;
            case 1:
                // Yacht(int yachtID, String name, String type, double length, int crewNumber, double enginePower, int sailsNumber)
                yacht = new Yacht(Integer.parseInt(data[1]), data[2], data[3], Double.valueOf(data[4]), Integer.parseInt(data[5]), Double.valueOf(data[6]), Integer.parseInt(data[7]));
                break;
        }
        return yacht;

        //throw new UnsupportedOperationException ();
    }

}
