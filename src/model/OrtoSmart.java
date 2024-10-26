package model;

import java.util.*;
import model.piante.*;

public class OrtoSmart {
    private static OrtoSmart instance;
    private Map<Scompartimento,SensoreUmidità> orto;    //La mappa che contiene la corrispondenza scompartimento col il rispettivo sensore
    private int numScompartimenti;

    public OrtoSmart(){
        this.orto = new HashMap<>();
        this.numScompartimenti =0;
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

    // Invocato dal controller nel momento in cui crea un nuovo scompartimento
    public Scompartimento aggiungiNuovoScompartimento(double maxUmidità) throws Exception{
        var sensore = new SensoreUmidità(0, maxUmidità);
        Scompartimento scompartimento = new Scompartimento(this.numScompartimenti,maxUmidità, sensore);
        try{
            this.orto.put(scompartimento,sensore);
            this.numScompartimenti++;
        } catch (Exception e){
            throw new Exception();
        }
        return scompartimento;
    }

    public void  rimuoviScompartimento(Scompartimento scompartimento){
        var presente = this.orto.containsKey(scompartimento);
        if(presente){
            this.orto.remove(scompartimento);
            this.numScompartimenti--;
        }
    }

    public void aggiungiPianta(int index, Pianta p) {
        List<Scompartimento> myList = new ArrayList<>(this.getScompartimenti());
        Scompartimento sc = null;
        try{
            sc = myList.get(index);
        } catch (Exception e){
            System.out.println("[ OrtoSmart.aggiungiPianta ]:"+e+" myList.size: "+myList.size());
        } finally{
            if(sc != null) sc.aggiungiPianta(p);
        }

    }
}
