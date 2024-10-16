package model.piante;
/*DESCRIZIONE CLASSE
 *  La seguente classe astratta definisce un comportamento comune a tutte la tipologie di piante che l'utente 
 *  può aggiungere al suo orto. 
 * 
 *  Definisce una serie di elementi comuni a tutte le piante come:
 *      - nome della pianta;
 *      - stagioni in cui la pianta si può coltivare;
 *      - range di umidità del suolo ottimale per la crescita della pianta.
 */

 import java.util.*;

public abstract class Pianta {

    // Campi della classe
    private String nome;
    private String[] stagioni;
    private double umiditàMin;
    private double umiditàMax;
    private StatoCrescita statoCorrenteCrescita;
    private Timer timer;

    //Costruttore
    public Pianta(String nome, String[] stagioni, double min, double max, long delay, long period){
        this.nome = nome;
        this.stagioni = stagioni.clone();
        this.umiditàMin = min;
        this.umiditàMax = max;
        this.statoCorrenteCrescita = StatoCrescita.GERMINAZIONE;
        this.timer = new Timer();
        timer.schedule(new CrescitaPianta(), delay, period);
    }

    // ------------------------------------------------------------------------------
    // Il seguente task definisce l'alternansi delle fasi della crescita della pianta 
    // ------------------------------------------------------------------------------ 
    private class CrescitaPianta extends TimerTask {
        @Override
        public void run() {
            cambiaFaseCrescita();
        }
    }

    // Metodi della classe
    public String getNome(){
        return this.nome;
    }

    public String[] getStagioni(){
        return this.stagioni.clone();
    }

    public double getUmiditàMin(){
        return this.umiditàMin;
    }

    public double getUmiditàMax(){
        return this.umiditàMax;
    }
    
    public StatoCrescita getStatoCrescita(){
        return this.statoCorrenteCrescita;
    }
    
    protected void setStatoCrescita(StatoCrescita nuovoStato){
        this.statoCorrenteCrescita = nuovoStato;
    }

     // ------------------------------------------------------------------------------
    //Metodo per aggiornare lo stato della crescita della pianta
    // ------------------------------------------------------------------------------
    public void cambiaFaseCrescita(){
        this.statoCorrenteCrescita = this.statoCorrenteCrescita.successivo();
    }

    // ------------------------------------------------------------------------------
    //Metodo per verificare se la pianta è pronta per essere raccolta
    // ------------------------------------------------------------------------------
    public boolean prontaDaRaccogliere(){
        return (this.statoCorrenteCrescita == StatoCrescita.SENESCENZA) ? true : false;
    } 
} 