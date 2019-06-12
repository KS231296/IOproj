/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBPack;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import owner.Yacht;

/**
 *
 * @author uaxau
 */
@Stateless
public class YachtFacade extends AbstractFacade<Yacht> {

    @PersistenceContext(unitName = "YachtRentDB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public YachtFacade() {
        super(Yacht.class);
    }
    public void addYacht(List<Yacht> yachts){
        for(Yacht yacht:yachts){
            if(yacht.getId() == null){
                getEntityManager().persist(yacht);
            }
        }
    }
    
}
