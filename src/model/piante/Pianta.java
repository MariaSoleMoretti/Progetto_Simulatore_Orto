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

 import java.awt.Color;
import java.util.*;

import controller.ControllerPianta;
import model.Scompartimento;

public abstract class Pianta {

    // ----------------------------------
    // Campi della classe
    // ----------------------------------
    private String nome;
    private String[] stagioni;
    private double umiditàMin;
    private double getValUmidità;
    private StatoCrescita statoCorrenteCrescita;
    private Timer timer;
    private Scompartimento scompartimento = null;
    private ControllerPianta controller = null;

    // ---------------------------------------------------------------------------------------------------------------
    // Costruttore della classe
    // ---------------------------------------------------------------------------------------------------------------
    public Pianta(Scompartimento sc, String nome, String[] stagioni, double min, long delay, long period){
        this.scompartimento = sc;
        this.nome = nome;
        this.stagioni = stagioni.clone();
        this.umiditàMin = min;
        this.getValUmidità = this.scompartimento.getValUmidità();
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

    // ----------------------------------
    // Metodi getter della classe
    // ----------------------------------
    public String getNome(){
        return this.nome;
    }

    public String[] getStagioni(){
        return this.stagioni.clone();
    }

    public double getUmiditàMin(){
        return this.umiditàMin;
    }

    public double getValUmidità() {
        return this.getValUmidità;
    } 
    
    public StatoCrescita getStatoCrescita(){
        return this.statoCorrenteCrescita;
    }

    public ControllerPianta getController() {
        return this.controller;
    }
    
    // ----------------------------------
    // Metodi setter della classe
    // ----------------------------------
    protected void setStatoCrescita(StatoCrescita nuovoStato){
        this.statoCorrenteCrescita = nuovoStato;
    }

    public void setController(ControllerPianta listener) {
        this.controller = listener;
    }

    // ------------------------------------------------------------------------------
    //Metodo per aggiornare lo stato della crescita della pianta
    // ------------------------------------------------------------------------------
    public void cambiaFaseCrescita(){
        this.statoCorrenteCrescita = this.statoCorrenteCrescita.successivo();
        this.controller.aggiornaStato(this.statoCorrenteCrescita.toString() );
        if(this.statoCorrenteCrescita == StatoCrescita.SENESCENZA){
            //System.out.println(this.nome+" è pronta al raccolto!");
            //this.scompartimento.prontoAlRaccolto();
            timer.cancel();
        }
    }

    // ------------------------------------------------------------------------------
    // Metodo per avere il riferimento alla scompartimento di cui la pianta fa parte.
    // Viene definito nel momento in cui tramite gui si aggiunge una nuova pianta.
    // ------------------------------------------------------------------------------
    public void setScompartimento(Scompartimento sc){
        this.scompartimento = sc;
    }

    // ------------------------------------------------------------------------------
    //Metodo per verificare se la pianta è pronta per essere raccolta
    // ------------------------------------------------------------------------------
    public boolean prontaDaRaccogliere(){
        return (this.statoCorrenteCrescita == StatoCrescita.SENESCENZA) ? true : false;
    }

    public void controllaUmidità(double umidità) {
        this.controller.notificaInnaffiare(umidità, this);
    }

} 