package controller;

import java.util.*;

import model.*;
import view.scompartimento.FinestraScompartimento;

import java.awt.event.*;

public class ControllerOrto implements ActionListener{
    OrtoSmart orto = OrtoSmart.getInstance();
    private static ControllerOrto instance;
    private List<FinestraScompartimento> finestreScomp;    //La mappa che contiene la corrispondenza scompartimento col il rispettivo sensore
    private int numFinestre = 0;

    public ControllerOrto(){
        this.finestreScomp = new LinkedList<>();
        this.finestreScomp.add(new FinestraScompartimento(this.numFinestre));
        this.numFinestre++;
    }

    // Definiszione della classe OrtoSmart come singleton
    public static ControllerOrto getInstance() {
        if (instance == null) {
            instance = new ControllerOrto();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(finestreScomp.size() < 4){
            finestreScomp.add(new FinestraScompartimento(this.numFinestre));
            this.numFinestre++;
        } else {
            System.out.println("Non si possono inserire più di 4 scompartimenti!");
        }
    }

    
}
