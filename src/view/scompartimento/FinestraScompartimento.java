package view.scompartimento;

import java.awt.BorderLayout;
import javax.swing.*;

public class FinestraScompartimento {
    final static int INDEX = 0;
    public static void main(String[] args){

        // Creo il frame e imposto titolo e altre proprieta'
        final JFrame frame = new JFrame();
        frame.setTitle("orto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Imposta il BorderLayout sul frame
        frame.setLayout(new BorderLayout());
        frame.add(new PanelScompartimento(INDEX), BorderLayout.CENTER);
        frame.add(new PanelAzioni(INDEX), BorderLayout.SOUTH);

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        frame.pack();
        frame.setResizable(false);

        // Alla fine rendo visible il JFrame
        frame.setVisible(true);
    }
}
