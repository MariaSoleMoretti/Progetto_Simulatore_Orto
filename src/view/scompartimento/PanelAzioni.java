package view.scompartimento;

import javax.swing.JPanel;

import model.Scompartimento;


public class PanelAzioni extends JPanel{

    public PanelAzioni(Scompartimento scompartimento){
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteInnaffia(scompartimento));
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteRaccogli(scompartimento));
    }
}
