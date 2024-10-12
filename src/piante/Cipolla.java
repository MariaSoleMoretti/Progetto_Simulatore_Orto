package piante;

import java.util.*;

public class Cipolla extends Pianta{
    final static String NOME = "Cipolla";
    final static String[] STAGIONI = {"Estate"};
    final static double UMIDITA_MIN = 0.60;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 1000;
    final static long PERIOD = 4000;

    private Timer timer;

    //Costruttore
    public Cipolla(){
        super(NOME, STAGIONI, UMIDITA_MIN, UMIDITA_MAX);
        this.timer = new Timer();
        timer.schedule(new CrescitaPianta(), DELAY, PERIOD);
    }

    // ------------------------------------------------------------------------------
    // Il seguente task definisce l'alternansi delle fasi della crescita della pianta 
    // ------------------------------------------------------------------------------ 
    private class CrescitaPianta extends TimerTask {
        @Override
        public void run() {
            aggiornaStatoCrescita();
        }
    }
}
