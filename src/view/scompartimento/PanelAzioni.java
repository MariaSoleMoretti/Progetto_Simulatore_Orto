package view.scompartimento;

import javax.swing.JPanel;

import controller.ControllerIrrigazione;
import controller.ControllerOrto;
import model.Scompartimento;

public class PanelAzioni extends JPanel{
    final ControllerIrrigazione controllerIrr = ControllerIrrigazione.getInstance();
    final ControllerOrto controllerOrto = ControllerOrto.getInstance();

    public PanelAzioni(){
        // Aggiungo un pulsante al pannello
        this.add(new BottoneInnaffia(controllerIrr));
        // Aggiungo un pulsante al pannello
        this.add(new BottoneNuovoScomp(new Scompartimento(0, 0, null),controllerOrto ));
    }
}
