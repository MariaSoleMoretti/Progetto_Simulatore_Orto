package view.scompartimento;

import javax.swing.*;

import model.Scompartimento;

import java.awt.event.*;

public class PulsanteInnaffia extends JButton{
    private final Scompartimento scompartimento;
    
    public PulsanteInnaffia(Scompartimento scomp){
        super("Innaffia");
        this.scompartimento = scomp;
        this.addActionListener(new ActionInnaffia());
    }

    public class ActionInnaffia implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            scompartimento.resetUmidità();
        }  
    }
}
