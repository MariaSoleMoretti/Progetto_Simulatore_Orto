package view.scompartimento;

import javax.swing.*;
import java.awt.*;


public class PanelAggiungiPiante extends JPanel{

    public PanelAggiungiPiante(int index){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Creo i pulsanti
        JButton buttonPomodoro = new PulsanteNuovaPianta(index, "Pomodoro");
        buttonPomodoro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonCipolla = new PulsanteNuovaPianta(index, "Cipolla");
        buttonCipolla.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Aggiungo un pulsante al pannello
        //this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPomodoro);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonCipolla);
    }
}

