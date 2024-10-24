package view;

import javax.swing.*;

import controller.ControllerIrrigazione;
import controller.ControllerScompartimenti;
import model.Scompartimento;

public class FinestraScompartimento {

    public static void main(String[] args){
    
        final ControllerIrrigazione controllerIrrigazione = new ControllerIrrigazione();
        final ControllerScompartimenti controllerScomp = new ControllerScompartimenti();

    // Creo il frame e imposto titolo e altre proprieta'
    final JFrame frame = new JFrame();
    frame.setTitle("Finestra Scompartimento");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(320,240);

    // Creo un pannello e gli imposto il bordino
    final JPanel panel = new JPanel();

    // Aggiungo il pannello ai "contenuti" del frame
    frame.getContentPane().add(panel);

    // Aggiungo un pulsante al pannello
    panel.add(new BottoneInnaffia(controllerIrrigazione));
    // Aggiungo un pulsante al pannello
    panel.add(new BottoneNuovoScomp(new Scompartimento(0, 0, null), controllerScomp));

    // Alla fine rendo visible il JFrame
    frame.setVisible(true);
    }
}
