package model.piante;

public class Cipolla extends Pianta{
    final static String NOME = "Cipolla";
    final static String[] STAGIONI = {  "Primavera",
                                        "Inverno"};
    final static double UMIDITA_MIN = 0.60;
    final static double UMIDITA_MAX = 0.70;
    final static long DELAY = 1000;
    final static long PERIOD = 4000;

    //Costruttore
    public Cipolla(){
        super(null,NOME, STAGIONI, UMIDITA_MIN, UMIDITA_MAX, DELAY, PERIOD);
    }
}
