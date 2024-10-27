package view.scompartimento;

import java.awt.*;
import javax.swing.*;

import controller.ControllerPianta;
import controller.ControllerScompartimento;

public class PanelScompartimento extends JPanel{
    final ControllerScompartimento controllerScompartimento = ControllerScompartimento.getInstance();
    
    public PanelScompartimento(int index) {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 300));
        this.setLayout(new GridLayout(2, 2, 4, 4)); // 2 righe e 2 colonne

        // Aggiungi 4 istanze di PanelPianta
        for (int i = 0; i < 4; i++) {
            PanelPianta p = new PanelPianta();
            this.add(p);
            this.controllerScompartimento.addListeners(new ControllerPianta(p));
        }
    }
}
