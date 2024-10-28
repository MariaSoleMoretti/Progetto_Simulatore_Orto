package model;

import java.util.*;
import model.piante.Pianta;

public class SensoreUmidità {
    private static final double VAL_MIN = 0.30;
    private final double MAX = 0.70;
    private Scompartimento scompartimento;
    private Timer timer;

    //Costruttore
    public SensoreUmidità(Scompartimento sc){
        this.scompartimento = sc;
        this.timer = new Timer();
        timer.schedule(new RiduzioneUmidità(), 3000, 2000);
    }

    // ------------------------------------------------------------------------------
    // Il seguente task diminuscie l'umidità del suolo dello scompartimento 
    // ------------------------------------------------------------------------------ 
    private class RiduzioneUmidità extends TimerTask {
        @Override
        public void run() {
            diminuisciUmidità();
            //System.out.println("Aggiornato Umidità");
        }
    }

    // --------------------------------------------------------------------------
    // Metodo per aggiornare il valore di umidità del sensore
    // --------------------------------------------------------------------------
    private void diminuisciUmidità(){
        var nuovoValore = this.scompartimento.getValUmidità()-0.05;
        if(nuovoValore < VAL_MIN){
            timer.cancel();
            timer = null;
        } else{
            this.scompartimento.setValUmidità(nuovoValore);
            notificaPiante(this.scompartimento.getValUmidità());
        }
    }

    public void aggiornaValUmidita(){
        this.scompartimento.setValUmidità(MAX);
        if(timer == null){
            timer.schedule(new RiduzioneUmidità(), 3000, 5000);
        }
        notificaPiante(MAX);
    }

    private void notificaPiante(double valUmidità){
        List<Pianta> piante = this.scompartimento.getPiante();
        //Si notifica alla pianta un cambiamento del valore dell'umidità dello scompartimento
        for (Pianta pianta : piante) {
            pianta.controllaUmidità(valUmidità);
        }
    }
}
