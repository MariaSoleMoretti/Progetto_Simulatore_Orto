package model;

import java.util.*;

import utils.MyUtils;


/*DESCRIZIONE CLASSE
 *  La seguente classe simula le condizione meteorologiche che influenzano la crescita delle piante. In particolare 
 *  si andranno a simulare:
 *  - la temperatura, che andrà a diminuire l'umidità del suolo;
 *  - la pioggia, che, al contrario della precedente, aumenterà l'umidità del suolo.
 */

public class Meteo {

    //Metodi della classe
    private int temperatura;
    private boolean pioggia;
    private Random rnd;
    private Timer timer;
    private Set<Scompartimento> listeners;

    //Costruttore della classe
    public Meteo(){
        this.rnd = new Random();
        this.temperatura = 20 + this.rnd.nextInt(5);
        this.pioggia = false;
        this.timer = new Timer();
        timer.schedule(new Pioggia(), 5000, 8000);
        timer.schedule(new Temperatura(), 2000, 3000);
        this.listeners = new TreeSet<>();
    }

    private class Pioggia extends TimerTask {
        @Override
        public void run() {
            faiPiovere();
        }
    }

    private class Temperatura extends TimerTask {
        @Override
        public void run() {
            cambiaTemperatura();
        }
    }

    //Metodi della classe
    public int getTemperatura(){
        return this.temperatura;
    }

    /* -----------------------------------------------------------------------------
    *  Modifica la temperatura in modo casuale.
    *  Aumenta o diminuisce la temperatura di un valore casuale compreso tra 0 e 9.
    *  ---------------------------------------------------------------------------- */ 
    public void cambiaTemperatura(){
        boolean tipoOp = this.rnd.nextBoolean();

        if(tipoOp){
            aumentaTemperatura(this.rnd.nextInt(10));
            //System.out.println("La temperatura sta aumentando!");
        } else {
            diminuisciTemperatura(this.rnd.nextInt(10));
            //System.out.println("La temperatura sta diminuendo!");
        }
    }

    /* ------------------------------------------------------------------
    *   Metodo per aumentare la temperature.
    *   Se l'incremento supera i 40 gradi, viene diminuita la temperatura 
    *   dello stesso valore.
    *
    *   @param val Il valore di incremento/decremento della temperatura.
    * -------------------------------------------------------------------- */
    private void aumentaTemperatura(double val){
        if(this.temperatura + val >= 40){
            diminuisciTemperatura(val);
        } else {
            this.temperatura += val;
        }
    }

    /* -------------------------------------------------------------------------
    *   Metodo per diminuire la temperature.
    *   Se il decremento scende sotto i 5 gradi, viene aumentata la temperatura 
    *   dello stesso valore.

    *   @param val Il valore di incremento/decremento della temperatura.
    * -------------------------------------------------------------------------- */
    private void diminuisciTemperatura(double val) {
        if(this.temperatura - val < 5){
            aumentaTemperatura(val);
        } else {
            this.temperatura -= val;
        }
    }

    public boolean getPioggia(){
        return this.pioggia;
    }

    public void faiPiovere(){
        this.pioggia = this.rnd.nextBoolean();
        if(this.pioggia){
            System.out.println("Sta piovendo!\n");
            //Notifico agli scompartimenti che ha piovuto
            MyUtils.notifyPioggia(listeners);
        } else {
            System.out.println("Non piove....\n");
        }
    }

    public void addListener(Scompartimento sc){
        try{
            this.listeners.add(sc);
        } catch (Exception e){
            System.out.println("Errore! \n "+ e );
        }
    }
}
