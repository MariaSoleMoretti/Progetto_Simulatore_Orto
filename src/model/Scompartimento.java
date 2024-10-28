package model;
import java.util.*;

import controller.*;
import model.piante.Pianta;

public class Scompartimento implements Comparable<Scompartimento> {
    
    final static int CAPIENZA = 4;
    final int ID;
    private List<Pianta> piante;
    private SensoreUmidità sensore;
    private double valUmidità;
    final double valMaxUmidità; 
    final ControllerScompartimento controllerScomp = ControllerScompartimento.getInstance();

    public Scompartimento(int id,List<Pianta> piante, double max){
        this.ID = id;
        this.piante = new ArrayList<>(piante);
        this.sensore = new SensoreUmidità(this);
        this.valMaxUmidità = this.valUmidità= max;
    }

    public Scompartimento(int id, double max){
        this(id,new ArrayList<>(), max);
    }

    // --------------------------------------------------------------------------
    // Metodo per aggiungere una pianta
    // --------------------------------------------------------------------------
    public void aggiungiPianta(Pianta p){
        //Aggiungo all'istanza della pianta il riferimetno allo scompartimento
        p.setScompartimento(this);
        //Se c'è uno slot libero, aggiungo la pianta
        if(this.piante.size() < CAPIENZA){
            try{
                this.piante.add(p);
                this.controllerScomp.aggiornaPanel(this.piante.size()-1,p);
            } catch (Exception e){
                System.out.println(e);
            }
            System.out.println("["+this.toString()+"]: Aggiungo 4 "+p.getNome());
        } else {
            System.out.println("Lo scompartimento è pieno.");
        }
    }

    // ----------------------------------
    // Metodi getter della classe
    // ----------------------------------
    public List<Pianta> getPiante(){
        return this.piante;
    }

    public SensoreUmidità getSensore(){
        return this.sensore;
    }

    public int getID() {
        return this.ID;
    }

    public double getValUmidità() {
        return this.valUmidità;
    }

    public void setValUmidità(double val) {
        this.valUmidità = val;
    }

    // -----------------------------------------------------------------------------
    // Invocato dall controller per raccogliere una pianta.
    // 
    // Trova nella lista delle piante quella che ha raggiunto lo stato di Senescenza
    // e la rimuove dalla lista.
    // -----------------------------------------------------------------------------
    public void prontoAlRaccolto(){
        boolean result = false;
        var iter = this.piante.iterator();
        Pianta pianta = null;

        //Se ci sono piante nello scompartimento si raccoglie
        if(!this.piante.isEmpty()){
            while(iter.hasNext() && !result){
                pianta = iter.next();
                if(pianta.prontaDaRaccogliere()){
                    result = true;
                }
            }
            //Se ci sono piante nello stato di senescenza di procede nella raccolta
            if(result){
                //Rimuovo la pianta dalla lista
                this.piante.remove(pianta);
                //Aggiorno la GUI
                this.controllerScomp.raccogliPianta(pianta);
                System.out.println(pianta.getNome()+" è stata raccolta!");
            }
        }
    }

    // --------------------------------------------------------------------------
    //  Metodo invocato quando avviene l'evento Pioggia.
    //
    //  Setta il valore di umidità al massimo.
    // --------------------------------------------------------------------------
    public void resetUmidità(){
        this.sensore.aggiornaValUmidita();
        System.out.println(this.toString()+" aggiorna umidità!");
    }

    @Override
    public String toString(){
        return "Scompartimento_"+this.ID;
    }

    @Override
    public int compareTo(Scompartimento o) {
        return(o.getSensore() == this.getSensore()? 1 : -1);
    }

}
