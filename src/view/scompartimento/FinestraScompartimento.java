package view.scompartimento;

import java.awt.BorderLayout;
import javax.swing.*;

public class FinestraScompartimento {

    public static void main(String[] args){

        // Creo il frame e imposto titolo e altre proprieta'
        final JFrame frame = new JFrame();
        frame.setTitle("Finestra Scompartimento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,240);

        // Imposta il BorderLayout sul frame
        frame.setLayout(new BorderLayout());
        frame.add(new PanelScompartimento(), BorderLayout.CENTER);
        frame.add(new PanelAzioni(), BorderLayout.SOUTH);


        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        frame.pack();
        frame.setResizable(false);

        // Alla fine rendo visible il JFrame
        frame.setVisible(true);
    }
}
