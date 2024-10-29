package view.scompartimento;

import javax.swing.JPanel;

import controller.*;


public class PanelAzioni extends JPanel{
    final ControllerIrrigazione controllerIrr = ControllerIrrigazione.getInstance();

    public PanelAzioni(int index, ControllerScompartimento controller){
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteInnaffia(controllerIrr));
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteRaccogli(controller));
    }
}
