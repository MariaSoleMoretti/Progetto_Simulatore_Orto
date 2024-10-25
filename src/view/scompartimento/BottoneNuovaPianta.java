package view.scompartimento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.*;
import model.piante.Pianta;

public class BottoneNuovaPianta extends JButton{
    final ControllerScompartimento controlleScomp = ControllerScompartimento.getInstance();

    public BottoneNuovaPianta(int index, Pianta pianta){
        super("Aggiungi "+pianta.getNome());
        this.addActionListener(new AggiungiPianta(index,pianta));
    }

    private class AggiungiPianta implements ActionListener{
        private Pianta pianta;
        private int id;
        public AggiungiPianta(int index,Pianta p){
            this.id = index;
            this.pianta = p;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            controlleScomp.aggiungiOrtaggio(this.id,this.pianta);
        }
        
    }
}
