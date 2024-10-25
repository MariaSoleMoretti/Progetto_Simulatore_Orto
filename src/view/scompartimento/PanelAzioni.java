package view.scompartimento;

import javax.swing.JPanel;

import controller.*;
import model.piante.*;


public class PanelAzioni extends JPanel{
    final ControllerIrrigazione controllerIrr = ControllerIrrigazione.getInstance();

    public PanelAzioni(int index){
        // Aggiungo un pulsante al pannello
        this.add(new BottoneInnaffia(controllerIrr));
        // Aggiungo un pulsante al pannello
        this.add(new BottoneNuovaPianta(index, new Pomodoro()));
    }
}
