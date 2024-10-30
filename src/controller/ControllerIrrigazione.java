package controller;

import model.*;
import java.awt.event.*;
public class ControllerIrrigazione implements ActionListener {

    final OrtoSmart orto = OrtoSmart.getInstance();
    private static Scompartimento scompartimento;

    public ControllerIrrigazione(Scompartimento sc) {
        scompartimento = sc;
    }
    /**
     * Notifica l'evento Irrigazione a tutti gli scompartimenti dell'orto
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(scompartimento);
        scompartimento.resetUmidità();
    }

}
