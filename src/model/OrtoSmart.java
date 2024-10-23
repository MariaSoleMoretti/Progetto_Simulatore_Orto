package model;

import java.util.*;

public class OrtoSmart {
    private Map<Scompartimento,SensoreUmidità> orto;    //La mappa che contiene la corrispondenza scompartimento col il rispettivo sensore

    public OrtoSmart(){
        this.orto = new HashMap<>();
    }

    public void attivaIrrigazione(int i){

    }

    public Set<Scompartimento> getScompartimenti(){
        return this.orto.keySet();
    }

    public void aggiungiNuovoScompartimento(double maxUmidità){
        var sensore = new SensoreUmidità(0, maxUmidità);
        Scompartimento scompartimento = new Scompartimento(this.orto.size(),maxUmidità, sensore);
        try{
            this.orto.putIfAbsent(scompartimento,sensore);
        } catch (Exception e){
            System.out.println(e);
        } 
    }

    public void  rimuoviScompartimento(Scompartimento scompartimento){
        var presente = this.orto.containsKey(scompartimento);
        if(presente){
            this.orto.remove(scompartimento);
        }
    }

    public static void main(String[] args) {
        OrtoSmart orto = new OrtoSmart();

        orto.aggiungiNuovoScompartimento(0.70);
        orto.aggiungiNuovoScompartimento(0.70);

        Meteo meteo = new Meteo();

        Set<Scompartimento> scompartiemnti = orto.getScompartimenti();

        for (Scompartimento sc : scompartiemnti) {
            meteo.addListener(sc);
        }
    }
}
