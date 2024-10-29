package view.scompartimento;

import javax.swing.*;

import model.Scompartimento;

import java.awt.event.*;

public class PulsanteRaccogli extends JButton {
    Scompartimento scompartimento ;
    public PulsanteRaccogli(Scompartimento scomp){
        super("Raccogli");
        this.scompartimento = scomp;
        this.addActionListener(new ActionRaccogli());
    }

    public class ActionRaccogli implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            scompartimento.prontoAlRaccolto();
        }  
    }
}
