package controller;

import model.*;
import utils.MyUtils;
import java.awt.event.*;
public class ControllerIrrigazione implements ActionListener {

    final OrtoSmart orto = OrtoSmart.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        MyUtils.notifyPioggia(orto.getScompartimenti());
    }
}
