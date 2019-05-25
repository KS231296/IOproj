/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesstier;

import java.time.LocalDate;
import javax.ejb.Remote;

/**
 *
 * @author xxx
 */
@Remote
public interface EJBFacadeRemote {

    public String addReservation(String[] data1, String[] data2, String datesofReservation[]);

    public Yacht searchFreeYacht(Yacht help, LocalDate date1, LocalDate dataKoncowa);

    public Client searchClient(Client client);

    public String addClient(String data[]);

    public Yacht searchYacht(Yacht yacht);
  
}
