package view.scompartimento;

import java.awt.BorderLayout;
import javax.swing.*;

import controller.ControllerScompartimento;

public class FinestraScompartimento extends JFrame {
    private static int INDEX;
    private static ControllerScompartimento controller;     //Controller dello scompartimento

    public FinestraScompartimento(){
        // Creo il frame e imposto titolo e altre proprieta'
        this.setTitle("orto");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controller = new ControllerScompartimento();
        // Imposta il BorderLayout sul frame
        this.setLayout(new BorderLayout());
        this.add(new PanelScompartimento(INDEX,controller), BorderLayout.WEST);
        this.add(new PanelAggiungiPiante(INDEX,controller), BorderLayout.EAST);
        this.add(new PanelAzioni(INDEX,controller), BorderLayout.SOUTH);

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        this.pack();
        this.setResizable(false);

        // Alla fine rendo visible il JFrame
        this.setVisible(true);
    }
}
