package controller;

import model.*;
import model.piante.Pianta;
import java.util.*;


public class ControllerScompartimento{

    final OrtoSmart orto = OrtoSmart.getInstance();         //Riferimento al singleton dell'orto smart
    private final Scompartimento scompartimento;           //Riferimento allo scompartimento corrispondente
    private List<ControllerPianta> controllers;             //Lista di PanelPianta per ppoter aggiornare la view quando si aggiorna il model

    //  Costruttore della classe
    public ControllerScompartimento(){
        scompartimento = nuovoScompartimento();
        this.controllers = new ArrayList<ControllerPianta>();
    }

    /**
    * Aggiunge un nuovo scompartimento nell'orto nel momento dell'avvio del programma
    */
    public Scompartimento nuovoScompartimento() {
        try{
            return this.orto.aggiungiNuovoScompartimento(0.70,this);
        } catch (Exception ex){
            System.out.println("Errore! Non è stato possibile aggiungere lo scompartimento.");
        } finally {
            System.out.println("Aggiunto un nuovo scompartimento..");
        }
        return null;
    }

    /**
    * Aggiunge nella lista controllers i controller delle piante
    *   @param cp -> instanza del controller da aggiungere tra i listeners.
    */
    public void addListeners(ControllerPianta cp){
        try{
            this.controllers.add(cp);
        } catch (Exception e){
            System.out.println("Errore! \n "+ e );
        }
    }

    /**
    * Funzoioen per aggiornare nella view il tipo di pianta coltivato. Utilizzata nella classe Scompartimento
    *   @param index -> indice per individuare il controller nella lista dei listeners
    *   @param pianta -> istanza della pianta da aggiornare.
    */
    public void aggiornaPanel(int index, Pianta pianta){
        ControllerPianta listener = null; 
        try{
            listener = this.controllers.get(index);
        } catch (Exception e){
            System.out.println("[ControllerScompartimento.aggiornaPiantaInPanel]: "+e);
            System.out.println(this.controllers.size());
        }
        if(listener != null){
            //Aggiungo all'istanza della pianto il controller corrispondente allo slot a cui è stata assegnata
            pianta.setController(listener);
            listener.aggiornaPiantaInPanel(pianta);
        }
    } 
    
    /**
    * Seleziona il controller corrispondete alla pianta che si vuole rimuovere.
    *   @param p -> istanza della pianta da cui ottenere il controller per poter effettuare le modifiche
    */
    public void raccogliPianta(Pianta p){
        ControllerPianta listener = null; 
        try{
            listener = p.getController();
        } catch (Exception e){
            System.out.println("[ControllerScompartimento.aggiornaPiantaInPanel]: "+e);
            System.out.println(this.controllers.size());
        }
        if(listener != null){
            listener.raccogliPianta();
        }
    }

    /**
    * Invocato nel momento in cui si vuole aggiungere un ortaggio tramite GUI
    *   @param index -> indice dello scompartimento in cui si vuole aggiungere la pianta
    *   @param p -> istanza della pianta da aggiungere
    */
    public void aggiungiOrtaggio(int index,Pianta p){
        this.orto.aggiungiPianta(index, p);
    }

    /**
     * Ritorna l'istanza dello scoampartimento associato al controller
    */
    public Scompartimento getScompartimento() {
        return scompartimento;
    }
}
