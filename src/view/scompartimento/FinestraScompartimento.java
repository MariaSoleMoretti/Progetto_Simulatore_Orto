package view.scompartimento;

import java.awt.BorderLayout;
import javax.swing.*;

import controller.ControllerScompartimento;

public class FinestraScompartimento extends JFrame {
    private static int INDEX;

    public FinestraScompartimento(int index){
        INDEX = index;
        // Creo il frame e imposto titolo e altre proprieta'
        this.setTitle("Scompartimento_"+index);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        ControllerScompartimento controller = new ControllerScompartimento();

        // Imposta il BorderLayout sul frame
        this.setLayout(new BorderLayout());
        this.add(new PanelScompartimento(controller), BorderLayout.WEST);
        this.add(new PanelAggiungiPiante(INDEX,controller), BorderLayout.EAST);
        this.add(new PanelAzioni(controller.getScompartimento()), BorderLayout.SOUTH);

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        this.pack();
        this.setResizable(false);

        // Alla fine rendo visible il JFrame
        this.setVisible(true);
    }
}
