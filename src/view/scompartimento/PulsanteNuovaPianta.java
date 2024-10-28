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

    /**
    * Costruttore del pulsante per aggiungere una nuova pianta.
    * Questo costruttore crea un pulsante personalizzato per aggiungere una nuova pianta di un tipo specifico all'orto.
    * 
    * @param index L'indice numerico dello scompartimento per identificarlo univocamente
    * @param tipoPianta Il tipo di pianta da aggiungere (es. "Pomodoro", "Cipolla") necessario per crearare un'istanza della classe corrispondente.
    */
    public PulsanteNuovaPianta(int index, String tipoPianta){
        super("Aggiungi "+ tipoPianta);
        this.addActionListener(new AggiungiPianta(index,tipoPianta));
    }

    private class AggiungiPianta implements ActionListener{
        private String tipoPianta;
        private int id;
        public AggiungiPianta(int index, String tipo){
            this.id = index;
            this.tipoPianta = tipo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Pianta pianta = null;
            switch (this.tipoPianta) {
                case "Pomodoro":
                    pianta = new Pomodoro(controlleScomp.getScompartimento());
                    break;
                case "Cipolla":
                    pianta = new Cipolla(controlleScomp.getScompartimento());
                default:
                    break;
            }
            controlleScomp.aggiungiOrtaggio(this.id,pianta);
        }
        
    }
}
