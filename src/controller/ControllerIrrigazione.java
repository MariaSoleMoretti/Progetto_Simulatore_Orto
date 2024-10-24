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

    @Override
    public void actionPerformed(ActionEvent e) {
        MyUtils.notifyPioggia(orto.getScompartimenti());
    }
}
