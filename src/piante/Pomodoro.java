package piante;

import java.util.*;

public class Pomodoro extends Pianta {
    final static String NOME = "Pomodoro";
    final static String[] STAGIONI = {"Estate"};
    final static double UMIDITA_MIN = 0.50;
    final static double UMIDITA_MAX = 0.70;

    private Timer timer;

    //Costruttore
    public Pomodoro(long delay, long period){
        super(NOME, STAGIONI, UMIDITA_MIN, UMIDITA_MAX);
        this.timer = new Timer();
        timer.schedule(new CrescitaPianta(), delay, period);
    }

    private class CrescitaPianta extends TimerTask {
        @Override
        public void run() {
            // Qui inserisci il codice del task da eseguire
        }
    }
    
}
