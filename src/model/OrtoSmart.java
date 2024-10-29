package model;

import java.util.*;

import controller.ControllerScompartimento;
import model.piante.*;

public class OrtoSmart {
    private static OrtoSmart instance;
    private List<Scompartimento> orto;    //La mappa che contiene la corrispondenza scompartimento col il rispettivo sensore
    private int numScompartimenti;

    public OrtoSmart(){
        this.orto = new LinkedList<>();
        this.numScompartimenti =0;
    }

    // Definiszione della classe OrtoSmart come singleton
    public static OrtoSmart getInstance() {
        if (instance == null) {
            instance = new OrtoSmart();
        }
        return instance;
    }

    // Metodi getter della classe
    public List<Scompartimento> getScompartimenti(){
        return this.orto;
    }

    /**
    * Invocato dal controller nel momento in cui crea un nuovo scompartimento.
    *   @param valUmidità -> valore iniziale di umidità dello socompartimento
    *   @throws NullPointerException -> se la lista orto è null
    */
    public Scompartimento aggiungiNuovoScompartimento(double valUmidità, ControllerScompartimento contr) throws NullPointerException{
        Scompartimento scompartimento = new Scompartimento(this.numScompartimenti,valUmidità,contr);
        try{
            this.orto.add(scompartimento);
            this.numScompartimenti++;
        } catch (NullPointerException e){
            throw e;
        }
        return scompartimento;
    }

    /**
    * Invocato dal controller nel momento in cui rimuove uno scompartimento.
    * @param scompartimento -> istanza dello scomaprtimento da rimuovere.
    */
    public void  rimuoviScompartimento(Scompartimento scompartimento){
        var presente = this.orto.contains(scompartimento);
        if(presente){
            this.orto.remove(scompartimento);
            this.numScompartimenti--;
        }
    }

    /**
     * Invocato dal controller nel momento in cui si aggiunge una nuova pianta.
     *  @param index -> indice dello scompartimento a cui aggiungere la pianta.
     *  @param p -> istanza della pianta da aggiungere
    */
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
