package view.scompartimento;

import java.awt.*;
import javax.swing.*;

import controller.ControllerPianta;
import controller.ControllerScompartimento;

public class PanelScompartimento extends JPanel{
    final ControllerScompartimento controllerScompartimento;
    
    /**
     * Costruttore del panel dello scompartimento. Instanzia 4 istanze della classe PanelPianta in cui verranno aggiunte le piante
     */
    public PanelScompartimento(ControllerScompartimento controller) {
        this.controllerScompartimento = controller;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 300));
        //Realizzazione di una griglia per contenere i panel delle piante
        this.setLayout(new GridLayout(2, 2, 4, 4)); 

        // Aggiungi 4 istanze di PanelPianta
        for (int i = 0; i < 4; i++) {
            PanelPianta p = new PanelPianta();
            this.add(p);
            this.controllerScompartimento.addListeners(new ControllerPianta(p));
        }
    }

    public ControllerScompartimento getController(){
        return this.controllerScompartimento;
    }
}
