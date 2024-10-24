package view.scompartimento;

import javax.swing.*;
import java.awt.event.*;

public class BottoneInnaffia extends JButton{
    
    public BottoneInnaffia(ActionListener controller){
        super("Innaffia");
        this.addActionListener(controller);
    }
}
