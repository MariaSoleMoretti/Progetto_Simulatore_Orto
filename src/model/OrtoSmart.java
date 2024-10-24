package model;

import java.util.*;

public class OrtoSmart {
    private static OrtoSmart instance;
    private Map<Scompartimento,SensoreUmidità> orto;    //La mappa che contiene la corrispondenza scompartimento col il rispettivo sensore

    public OrtoSmart(){
        this.orto = new HashMap<>();
    }

    public static OrtoSmart getInstance() {
        if (instance == null) {
            instance = new OrtoSmart();
        }
        return instance;
    }

    public void attivaIrrigazione(int i){

    }

    public Set<Scompartimento> getScompartimenti(){
        return this.orto.keySet();
    }

    public void aggiungiNuovoScompartimento(double maxUmidità) throws Exception{
        var sensore = new SensoreUmidità(0, maxUmidità);
        Scompartimento scompartimento = new Scompartimento(this.orto.size(),maxUmidità, sensore);
        this.orto.putIfAbsent(scompartimento,sensore);
    }

    public void  rimuoviScompartimento(Scompartimento scompartimento){
        var presente = this.orto.containsKey(scompartimento);
        if(presente){
            this.orto.remove(scompartimento);
        }
    }

    public static void main(String[] args) {
        OrtoSmart orto = new OrtoSmart();

        Meteo meteo = new Meteo();

        Set<Scompartimento> scompartiemnti = orto.getScompartimenti();

        for (Scompartimento sc : scompartiemnti) {
            meteo.addListener(sc);
        }
    }
}
