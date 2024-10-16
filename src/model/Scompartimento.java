package model;
import java.util.*;

import model.piante.Pianta;

public class Scompartimento implements EventListener {
    
    final static int CAPIENZA = 4;
    private List<Pianta> piante;
    private double valUmidità;
    final double valMaxUmidità; 

    public Scompartimento(List<Pianta> piante, double max){
        this.piante = new ArrayList<>(piante);
        this.valMaxUmidità = max;
    }

    public Scompartimento(double max){
        this.piante = new ArrayList<>();
        this.valMaxUmidità= max;
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

    public void modificaUmidità(){
        this.valUmidità = valMaxUmidità;
        System.out.println("Umidità: "+ this.valUmidità*100+"%");
    }

    public void modificaTemperatura(double temp) {
        
    }

}
