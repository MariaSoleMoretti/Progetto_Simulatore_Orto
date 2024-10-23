package model;
import java.util.*;

import model.piante.Pianta;

public class Scompartimento implements EventListener, Comparable {
    
    final static int CAPIENZA = 4;
    final int ID;
    private List<Pianta> piante;
    private SensoreUmidità sensore;
    private double valUmidità;
    final double valMaxUmidità; 

    public Scompartimento(int id,List<Pianta> piante, SensoreUmidità sensore, double max){
        this.ID = id;
        this.piante = new ArrayList<>(piante);
        this.sensore = sensore;
        this.valMaxUmidità = max;
    }

    public Scompartimento(int id, double max,SensoreUmidità sensore){
        this(id,new ArrayList<>(), sensore, max);
    }

    public void aggiungiPianta(Pianta p){
        if(this.piante.size() < CAPIENZA){
            this.piante.add(p);
        } else {
            System.out.println("Lo scompartimento è pieno.");
        }
    }

    public List<Pianta> getPiante(){
        return this.piante;
    }

    public SensoreUmidità getSensore(){
        return this.sensore;
    }

    public boolean prontoAlRaccolto(){
        boolean piantaMatura = false;
        Iterator<Pianta> iter = this.piante.iterator();

        while(iter.hasNext() && !piantaMatura){
            Pianta currPianta = (Pianta) iter.next();
            if(currPianta.prontaDaRaccogliere()){
                return !piantaMatura;
            }
        }
        return piantaMatura;
    }

    public void raccogliOrtaggio(){
        Iterator<Pianta> iter = this.piante.iterator();
        
        while(iter.hasNext()){
            Pianta currPianta = (Pianta) iter.next();
            if(currPianta.prontaDaRaccogliere()){
                this.piante.remove(currPianta);
            }
        }
    }

    //Metodo per aggiornare il valore di umidità del sensore
    public void aggiornaValoreUmidità(){
        this.sensore.aggiornaValoreUmidità(this.valUmidità);
    }

    //Metodo invocato quando avviene l'evento Pioggia
    //Setta il valore di umidità al massimo
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
    public int compareTo(Object o) {
        return(o.toString() == this.toString()? 1 : -1);
    }

}
