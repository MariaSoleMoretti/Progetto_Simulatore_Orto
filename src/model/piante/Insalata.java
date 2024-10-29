package model.piante;

import model.Scompartimento;

public class Insalata extends Pianta{
    final static String NOME = "Insalata";
    final static double UMIDITA_MIN = 0.60;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 5000;
    final static long PERIOD = 5000;

    //Costruttore
    public Insalata(Scompartimento sc){
        super(sc,NOME, UMIDITA_MIN, DELAY, PERIOD);
    }
}
