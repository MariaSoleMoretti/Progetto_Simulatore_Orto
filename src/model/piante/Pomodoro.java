package model.piante;

import model.Scompartimento;

public class Pomodoro extends Pianta {
    final static String NOME = "Pomodoro";
    final static double UMIDITA_MIN = 0.50;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 4000;
    final static long PERIOD = 9000;

    //Costruttore
    public Pomodoro(Scompartimento sc){
        super(sc,NOME, UMIDITA_MIN, DELAY, PERIOD);
    }
}
