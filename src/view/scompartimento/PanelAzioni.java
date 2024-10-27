package view.scompartimento;

import javax.swing.JPanel;

import controller.*;
import view.orto.*;


public class PanelAzioni extends JPanel{
    final ControllerIrrigazione controllerIrr = ControllerIrrigazione.getInstance();
    final ControllerScompartimento controllerScomp = ControllerScompartimento.getInstance();

    public PanelAzioni(int index){
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteInnaffia(controllerIrr));
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteRaccogli(controllerScomp));
    }
}
