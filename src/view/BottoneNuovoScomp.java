package view;

import javax.swing.*;

import controller.ControllerScompartimenti;
import model.Scompartimento;

public class BottoneNuovoScomp extends JButton{
    
    public BottoneNuovoScomp(Scompartimento scompartimento, ControllerScompartimenti c){
        super("Aggiungi scompartimento");
        this.addActionListener(c);
    }
}
