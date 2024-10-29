package view.scompartimento;

import javax.swing.*;

import controller.ControllerScompartimento;

import java.awt.*;


public class PanelAggiungiPiante extends JPanel{

    public PanelAggiungiPiante(int index, ControllerScompartimento controller){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Creo i pulsanti
        JButton buttonPomodoro = new PulsanteNuovaPianta(index, "Pomodoro",controller);
        buttonPomodoro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonCipolla = new PulsanteNuovaPianta(index, "Cipolla",controller);
        buttonCipolla.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonInsalata = new PulsanteNuovaPianta(index, "Insalata",controller);
        buttonInsalata.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonCarota = new PulsanteNuovaPianta(index, "Carota",controller);
        buttonCarota.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Aggiungo un pulsante al pannello
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPomodoro);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonCipolla);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonInsalata);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonCarota);
        
    }
}

