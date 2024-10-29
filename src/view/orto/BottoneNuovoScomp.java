package view.orto;

import javax.swing.*;

import controller.*;

public class BottoneNuovoScomp extends JButton{
    private ControllerOrto controller = ControllerOrto.getInstance();
    
    public BottoneNuovoScomp(){
        super("Aggiungi scompartimento");
        this.addActionListener(controller);
    }
}
