package view.orto;

import javax.swing.*;

import controller.*;
import model.Scompartimento;

public class BottoneNuovoScomp extends JButton{
    
    public BottoneNuovoScomp(Scompartimento scompartimento, ControllerScompartimento c){
        super("Aggiungi scompartimento");
        //this.addActionListener(c);
    }
}
