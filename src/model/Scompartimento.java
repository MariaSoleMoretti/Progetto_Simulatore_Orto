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

    public Scompartimento(int id,List<Pianta> piante, SensoreUmidità sensore, double max){
        this.ID = id;
        this.piante = new ArrayList<>(piante);
        this.sensore = sensore;
        this.valMaxUmidità = max;
    }

    public Scompartimento(int id, double max,SensoreUmidità sensore){
        this(id,new ArrayList<>(), sensore, max);
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

    // -----------------------------------------------------------------------------
    // Invocato dall controller per raccogliere una pianta.
    // 
    // Trova nella lista delle piante quella che ha raggiunto lo stato di Senescenza
    // e la rimuove dalla lista.
    // -----------------------------------------------------------------------------
    public void prontoAlRaccolto(){
        int index = 0;
        boolean result = false;
        var iter = this.piante.iterator();
        Pianta pianta = null;

        //Se ci sono piante nello scompartimento si raccoglie
        if(!this.piante.isEmpty()){
            while(iter.hasNext() && !result){
                pianta = iter.next();
                if(pianta.prontaDaRaccogliere()){
                    index = this.piante.indexOf(pianta);
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
    // Metodo per aggiornare il valore di umidità del sensore
    // --------------------------------------------------------------------------
    public void aggiornaValoreUmidità(){
        this.sensore.aggiornaValoreUmidità(this.valUmidità);
    }

    // --------------------------------------------------------------------------
    //  Metodo invocato quando avviene l'evento Pioggia.
    //
    //  Setta il valore di umidità al massimo.
    // --------------------------------------------------------------------------
    public void resetUmidità(){
        this.valUmidità = valMaxUmidità;
        System.out.println(this.toString()+" aggiorna umidità: "+ this.valUmidità*100+"%");
    }

    public void modificaTemperatura(double temp) {
        
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
