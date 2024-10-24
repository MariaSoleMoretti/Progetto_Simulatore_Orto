package controller;

import model.*;
import utils.MyUtils;
import java.awt.event.*;
import java.util.*;
public class ControllerIrrigazione implements ActionListener {

    private Set<Scompartimento> listeners;

    @Override
    public void actionPerformed(ActionEvent e) {
        MyUtils.notifyPioggia(listeners);
    }
}
