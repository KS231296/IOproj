package factoryAndFacade;

import client.Client;
import client.Reservation;
import owner.Yacht;

import java.time.LocalDate;
import java.util.IllegalFormatCodePointException;

public class Factory {

    public Client createClient(String data[]) {
        Client client = null;

        switch (Integer.parseInt(data[0])) {
            case 0:
                client = new Client();
                client.setClientID(data[1]);
                break;
            case 1:
                client = new Client(data[1], data[2], data[3], data[4]);
                break;
        }
        return client;
    }

    public Reservation createReservation(String data[], Yacht yacht, Client client) {
        Reservation reservation = null;

        switch (Integer.parseInt(data[0])) {
            case 0:
                reservation = new Reservation();
                reservation.setNumber(Integer.valueOf(data[1]));
                break;
            case 1:
                reservation = new Reservation();
                reservation.setNumber(Integer.valueOf(data[1]));
                reservation.setClient(client);
                reservation.setDateStart(LocalDate.parse(data[2]));
                reservation.setDateEnd(LocalDate.parse(data[3]));
                reservation.setModel(yacht);
                break;
            default:
                throw new IllegalFormatCodePointException(0);
        }
        return reservation;
    }

    public Yacht createYacht(String[] data) {

        Yacht yacht = null;

        switch (Integer.parseInt(data[0])) {

            case 0:

                yacht = new Yacht();
                for(int i=4;i<data.length;i++){
                    if(data[i].equals("")){
                        data[i] = "0";
                    }
                }

                            
                yacht.setYachtID(data[1]);
                              
                yacht.setName(data[2]);
                               
                yacht.setType(data[3]);
                yacht.setLength(Double.valueOf(data[4]));
                yacht.setCrewNumber(Integer.parseInt(data[5]));
                yacht.setEnginePower(Double.valueOf(data[6]));
                yacht.setSailsNumber(Integer.parseInt(data[7]));
                
    
break;
            case 1:
                // Yacht(int yachtID, String name, String type, double length, int crewNumber, double enginePower, int sailsNumber)
                yacht = new Yacht(data[1], data[2], data[3], Double.valueOf(data[4]), Integer.parseInt(data[5]), Double.valueOf(data[6]), Integer.parseInt(data[7]));
                                System.out.println("FACTORY 1: "+yacht);

                break;
                
        }
        return yacht;

        //throw new UnsupportedOperationException ();
    }

}
