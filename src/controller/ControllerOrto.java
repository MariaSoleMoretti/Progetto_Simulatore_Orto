package controller;

import model.*;
import java.awt.event.*;

public class ControllerOrto implements ActionListener{

    final OrtoSmart orto = OrtoSmart.getInstance();
    private static ControllerOrto instance;

    public static ControllerOrto getInstance() {
        if (instance == null) {
            instance = new ControllerOrto();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            this.orto.aggiungiNuovoScompartimento(0.70);
        } catch (Exception ex){
            System.out.println("Errore! Non è stato possibile aggiungere lo scompartimento.");
        } finally {
            System.out.println("Aggiunto un nuovo scompartimento..");

        }
    }
    
}
