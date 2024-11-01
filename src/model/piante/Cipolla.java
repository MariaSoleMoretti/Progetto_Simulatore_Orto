package model.piante;

import model.Scompartimento;

public class Cipolla extends Pianta{
    final static String NOME = "Cipolla";
    final static double UMIDITA_MIN = 0.40;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 5000;
    final static long PERIOD = 13000;

    //Costruttore
    public Cipolla(Scompartimento sc){
        super(sc,NOME, UMIDITA_MIN, DELAY, PERIOD);
    }
}
