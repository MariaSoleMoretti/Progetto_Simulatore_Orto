package model;

import java.util.*;
import model.piante.Pianta;

public class SensoreUmidità {
    private static final double VAL_MIN = 0.30;     //Limite inferiore di umidità dello scompartimento
    private final double VAL_MAX = 0.70;            //Limite superiore di umidità dello scompartimento
    private Scompartimento scompartimento;
    private Timer timer;

    //Costruttore
    public SensoreUmidità(Scompartimento sc){
        this.scompartimento = sc;
        this.timer = new Timer();
        timer.schedule(new RiduzioneUmidità(), 3000, 2000);
    }

    // Il seguente task diminuscie l'umidità del suolo dello scompartimento 
    private class RiduzioneUmidità extends TimerTask {
        @Override
        public void run() {
            diminuisciUmidità();
        }
    }

    /**
     * Metodo per diminuire il valore di umidità del sensore. Quando il valore di umidità
     * dello scompartimento è inferiore al valore minimo definito dalla costante VAL_MIN
     * si interrempe il timer.
     */
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

    /**
     * Metodo invocato per cambiare il valore dell'umidità nel model Scompartimento. 
     * Quando avviene l'evento di irrigazione si crea una nuova istanza del timer.
     */
    public void aggiornaValUmidita(){
        this.scompartimento.setValUmidità(VAL_MAX);
        if(timer == null){
            this.timer = new Timer();
            timer.schedule(new RiduzioneUmidità(), 3000, 5000);
        }
        System.out.println("["+scompartimento.toString()+"]"+" aggiorna umidità");
        notificaPiante(VAL_MAX);
    }

    /**
     * Metodo invocato per notificare al model Pianta un modifica del valore dell'umidità
     *  @param valUmidità -> nuovo valore di umidità da notificare alle piante.
     */
    private void notificaPiante(double valUmidità){
        List<Pianta> piante = this.scompartimento.getPiante();
        //Si notifica alla pianta un cambiamento del valore dell'umidità dello scompartimento
        if(!piante.isEmpty()){
            for (Pianta pianta : piante) {
                pianta.controllaUmidità(valUmidità);
            }
        }
    }
}
