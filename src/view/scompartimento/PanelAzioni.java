package view.scompartimento;

import javax.swing.JPanel;

import controller.*;


public class PanelAzioni extends JPanel{
    final ControllerIrrigazione controllerIrr = ControllerIrrigazione.getInstance();

    public PanelAzioni(int index){
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteInnaffia(controllerIrr));
        // Aggiungo un pulsante al pannello
        this.add(new PulsanteNuovaPianta(index, "Pomodoro"));
        this.add(new PulsanteNuovaPianta(index, "Cipolla"));
    }
}
