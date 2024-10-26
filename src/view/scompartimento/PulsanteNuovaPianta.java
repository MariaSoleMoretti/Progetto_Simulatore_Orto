package view.scompartimento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.*;
import model.piante.Cipolla;
import model.piante.Pianta;
import model.piante.Pomodoro;

public class PulsanteNuovaPianta extends JButton{
    final ControllerScompartimento controlleScomp = ControllerScompartimento.getInstance();
    private Pianta pianta;

    /**
    * Costruttore del pulsante per aggiungere una nuova pianta.
    * Questo costruttore crea un pulsante personalizzato per aggiungere una nuova pianta di un tipo specifico all'orto.
    * 
    * @param index L'indice numerico dello scompartimento per identificarlo univocamente
    * @param tipoPianta Il tipo di pianta da aggiungere (es. "Pomodoro", "Cipolla") necessario per crearare un'istanza della classe corrispondente.
    */
    public PulsanteNuovaPianta(int index, String tipoPianta){
        super("Aggiungi "+ tipoPianta);
        switch (tipoPianta) {
            case "Pomodoro":
                pianta = new Pomodoro();
                break;
            case "Cipolla":
                pianta = new Cipolla();
            default:
                break;
        }
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
