package model.piante;

import model.Scompartimento;

public class Cipolla extends Pianta{
    final static String NOME = "Cipolla";
    final static String[] STAGIONI = {  "Primavera",
                                        "Inverno"};
    final static double UMIDITA_MIN = 0.60;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 5000;
    final static long PERIOD = 11000;

    //Costruttore
    public Cipolla(Scompartimento sc){
        super(sc,NOME, STAGIONI, UMIDITA_MIN, DELAY, PERIOD);
    }
}
