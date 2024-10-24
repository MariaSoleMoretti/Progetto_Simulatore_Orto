package controller;

import model.*;
import java.awt.event.*;

public class ControllerScompartimenti implements ActionListener{

    final OrtoSmart orto = OrtoSmart.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            this.orto.aggiungiNuovoScompartimento(0);
        } catch (Exception ex){
            System.out.println("Errore! Non è stato possibile aggiungere lo scompartimento.");
        } finally {
            System.out.println("Aggiunto un nuovo scompartimento..");

        }
    }
    
}
