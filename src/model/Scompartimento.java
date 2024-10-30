package model;
import java.util.*;

import controller.*;
import model.piante.Pianta;

public class Scompartimento {
    
    final static int CAPIENZA = 4;
    final int ID;
    private List<Pianta> piante;
    private SensoreUmidità sensore;
    private double valUmidità;
    final ControllerScompartimento controllerScomp;
    final OrtoSmart orto = OrtoSmart.getInstance();

    public Scompartimento(int id, double max, ControllerScompartimento contr){
        this.ID = id;
        this.controllerScomp = contr;
        this.piante = new ArrayList<>();
        this.sensore = new SensoreUmidità(this);
        this.valUmidità= max;
    }

    /**
     * Metodo per aggiungere una pianta.
     * @param p -> istanza della pianta da aggiungere alla lista delle piante dello scompartimento.
     * */
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
            System.out.println("["+this.toString()+"]: Aggiungo "+p.getNome());
        } else {
            System.out.println("Lo scompartimento è pieno.");
        }
    }

    // Metodi getter della classe
    public List<Pianta> getPiante(){
        return this.piante;
    }

    public double getValUmidità() {
        return this.valUmidità;
    }

    // Metodi setter della classe
    public void setValUmidità(double val) {
        this.valUmidità = val;
    }

    /**
     * Invocato dall controller per raccogliere una pianta.
     * Trova nella lista delle piante quella che ha raggiunto lo stato di Senescenza
     * e la rimuove dalla lista.
     * */
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
                //Aumento totalizzatore verdure in orto
                orto.setNumVerdure(pianta);
                //Aggiorno la GUI
                this.controllerScomp.raccogliPianta(pianta);
                //System.out.println("["+this.toString()+"]: Raccolti 4 "+pianta.getNome()+"!");
            }
        }
    }

    /**
     * Metodo invocato quando avviene l'evento Pioggia.
     * Setta il valore di umidità al massimo.
     */
    public void resetUmidità(){
        this.sensore.aggiornaValUmidita();
    }

    @Override
    public String toString(){
        return "Scompartimento_"+this.ID;
    }

}
