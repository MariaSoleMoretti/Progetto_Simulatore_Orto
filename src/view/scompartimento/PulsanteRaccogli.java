package view.scompartimento;

import javax.swing.*;
import java.awt.event.*;

public class PulsanteRaccogli extends JButton {
    public PulsanteRaccogli(ActionListener controller){
        super("Raccogli");
        this.addActionListener(controller);
    }
}
