package view;
import java.util.*;

import view.piante.Pianta;

public class Scompartimento {
    
    final static int CAPIENZA = 4;
    private List<Pianta> piante;
    private Meteo meteo;

    public Scompartimento(List<Pianta> piante, Meteo meteo){
        Collections.copy(this.piante, piante);
        this.meteo = meteo;
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

    public double leggiUmidità(){
        return 0.0;
    }
}
