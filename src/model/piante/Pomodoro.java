package model.piante;

public class Pomodoro extends Pianta {
    final static String NOME = "Pomodoro";
    final static String[] STAGIONI = {"Primavera"};
    final static double UMIDITA_MIN = 0.50;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 4000;
    final static long PERIOD = 5000;

    //Costruttore
    public Pomodoro(){
        super(null,NOME, STAGIONI, UMIDITA_MIN, UMIDITA_MAX, DELAY, PERIOD);
    }
}
