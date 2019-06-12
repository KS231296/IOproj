/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientTier;
import sample.Launch;
import Yachts.YachtsBeanRemote;

import javax.ejb.EJB;

/**
 *
 * @author uaxau
 */
public class Main {

    @EJB
    private static YachtsBeanRemote yachtsBean;
    
    public static YachtsBeanRemote getFacade(){
        return  yachtsBean;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()-> {
            Launch.main(args);
        });
        
    }
    
}
