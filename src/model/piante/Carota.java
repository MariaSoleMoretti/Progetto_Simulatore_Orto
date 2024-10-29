package model.piante;

import model.Scompartimento;

public class Carota extends Pianta{
    final static String NOME = "Carota";
    final static double UMIDITA_MIN = 0.50;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 5000;
    final static long PERIOD = 11000;

    //Costruttore
    public Carota(Scompartimento sc){
        super(sc,NOME, UMIDITA_MIN, DELAY, PERIOD);
    }
}
