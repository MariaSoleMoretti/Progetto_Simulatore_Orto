package controller;

import model.*;
import utils.MyUtils;
import java.awt.event.*;
public class ControllerIrrigazione implements ActionListener {

    final OrtoSmart orto = OrtoSmart.getInstance();
    private static ControllerIrrigazione instance;

    public static ControllerIrrigazione getInstance() {
        if (instance == null) {
            instance = new ControllerIrrigazione();
        }
        return instance;
    }

    /**
     * Notifica l'evento Irrigazione a tutti gli scompartimenti dell'orto
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MyUtils.notifyIrrigazione(orto.getScompartimenti());
    }
}
