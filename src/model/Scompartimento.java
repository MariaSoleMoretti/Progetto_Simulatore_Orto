package model;
import java.util.*;

import controller.*;
import model.piante.Pianta;
import view.scompartimento.PanelPianta;

public class Scompartimento implements EventListener, Comparable<Scompartimento> {
    
    final static int CAPIENZA = 4;
    final int ID;
    private List<Pianta> piante;
    private SensoreUmidità sensore;
    private double valUmidità;
    final double valMaxUmidità; 
    final ControllerScompartimento controllerOrto = ControllerScompartimento.getInstance();

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
        p.setScompartimento(this);
        if(this.piante.size() < CAPIENZA){
            try{
                this.piante.add(p);
                this.controllerOrto.aggiornaPiantaInPanel(this.piante.size(),p.getNome());
            } catch (Exception e){
                System.out.println(e);
            }
            System.out.println("Aggiungo 4 "+p.getNome());
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

    //Invocato dalla pianta nel momento in cui raggiunge lo stato di Senescenza
    public void prontoAlRaccolto(){
        int index = 0;
        boolean result = false;
        var iter = this.piante.iterator();
        Pianta pianta = null;

        /*for (Pianta pianta : piante) {
            if(pianta.prontaDaRaccogliere()){
                this.piante.remove(pianta);
                this.controllerOrto.aggiornaPiantaInPanel(index,"Vuoto");
            }
            index++;
        }*/

        while(iter.hasNext() || !result){
            pianta = iter.next();
            if(pianta.prontaDaRaccogliere()){
                index = this.piante.indexOf(pianta);
                result = true;
            }
        }

        this.piante.remove(pianta);
        this.controllerOrto.aggiornaPiantaInPanel(index,"Vuoto");
        System.out.println(pianta.getNome()+" è stata raccolta!");
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
    public int compareTo(Scompartimento o) {
        return(o.getSensore() == this.getSensore()? 1 : -1);
    }

    public void addListener(PanelPianta p) {
        
    }

}
