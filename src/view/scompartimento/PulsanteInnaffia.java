package view.scompartimento;

import javax.swing.*;
import java.awt.event.*;

public class PulsanteInnaffia extends JButton{
    
    public PulsanteInnaffia(ActionListener controller){
        super("Innaffia");
        this.addActionListener(controller);
    }
}
