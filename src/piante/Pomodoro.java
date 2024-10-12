package piante;

import java.util.*;

public class Pomodoro extends Pianta {
    final static String NOME = "Pomodoro";
    final static String[] STAGIONI = {"Estate"};
    final static double UMIDITA_MIN = 0.50;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 1000;
    final static long PERIOD = 2000;

    private Timer timer;

    //Costruttore
    public Pomodoro(){
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

    public static void main(String[] args) {
        Pianta pomodoro = new Pomodoro();
        //Pianta cipolla = new Cipolla();
        String[] stagioni = pomodoro.getStagioni();
        for (String stagione : stagioni) {
            System.out.println(stagione);
        }
    }
}
