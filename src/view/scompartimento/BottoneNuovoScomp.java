package view.scompartimento;

import javax.swing.*;

import controller.ControllerOrto;
import model.Scompartimento;

public class BottoneNuovoScomp extends JButton{
    
    public BottoneNuovoScomp(Scompartimento scompartimento, ControllerOrto c){
        super("Aggiungi scompartimento");
        this.addActionListener(c);
    }
}
