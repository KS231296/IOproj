package YachtTier;

import DBPack.ClientFacade;
import DBPack.YachtFacade;
import factoryAndFacade.Facade;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class BeanDB implements BeanDBRemote {

    @EJB
    private YachtFacade yachtFacade;
    
    @EJB
    private ClientFacade clientFacade;

    static Facade facade = new Facade();
    
    @Override
    public void addYachts() {
        yachtFacade.addYacht(facade.getYachts());
    }

    @Override
    public void addClients() {
        clientFacade.addClient(facade.getClients());
    }
}
