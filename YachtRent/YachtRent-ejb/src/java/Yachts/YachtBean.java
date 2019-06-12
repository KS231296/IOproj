
package Yachts;

import factoryAndFacade.Facade;
import javax.ejb.Stateless;

/**
 *
 * @author uaxau
 */
@Stateless
public class YachtBean implements YachtsBeanRemote {

    Facade facade = new Facade();
    
    @Override
    public String[] getClientsData() {
        return facade.getClientsData();
    }

    @Override
    public String[] getYachtsData() {
        return facade.getYachtsData();
    }

    @Override
    public String addReservation(String[] dataOfClient, String[] dataYacht, String[] datesOfReservations) {
        return facade.addReservation(dataOfClient, dataYacht, datesOfReservations);
    }

    @Override
    public String addClient(String[] data) {
        return facade.addClient(data);
    }

    @Override
    public void deleteClient(String clientID) {
        facade.deleteClient(clientID);
    }

    @Override
    public void modifyClient(String modifiedParam, String[] newValue) {
        facade.modifyClient(modifiedParam, newValue);
    }

    @Override
    public String addYacht(String[] data) {
        return facade.addYacht(data);
    }

    @Override
    public void deleteYacht(String yachtID) {
         facade.deleteYacht(yachtID);
    }

    @Override
    public String[] searchYachts(String[] data) {
        return facade.searchYachts(data);
    }

    @Override
    public String[] searchClients(String[] data) {
        return facade.searchClients(data);
    }

    @Override
    public void modifyYacht(String modifiedParameter, String[] data) {
        facade.modifyYacht(modifiedParameter, data);
    }

    @Override
    public String searchClient(String[] clientData) {
        return facade.searchClient(clientData);
    }

    @Override
    public String searchYacht(String[] yachtData) {
        return facade.searchYacht(yachtData);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

