package YachtTier;

import DBPack.ClientFacade;
import DBPack.ReservationFacade;
import DBPack.YachtFacade;
import factoryAndFacade.Facade;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class BeanDB implements BeanDBRemote {

    @EJB
    private YachtFacade yachtFacade;

    @EJB
    private ReservationFacade reservationFacade;

    @EJB
    private ClientFacade clientFacade;

    
    static Facade facade = new Facade();
    
    
    @Override
    public void addYacht() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addReservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
