package controller;

import model.*;
import model.piante.Pianta;
import java.util.*;


public class ControllerScompartimento{

    final OrtoSmart orto = OrtoSmart.getInstance();
    private static ControllerScompartimento instance;
    private List<ControllerPianta> controllers;             //Lista di PanelPianta per ppoter aggiornare la view quando si aggiorna il model

    public static ControllerScompartimento getInstance() {
        if (instance == null) {
            instance = new ControllerScompartimento();
            instance.nuovoScompartimento();
        }
        return instance;
    }

    public ControllerScompartimento(){
        this.controllers = new ArrayList<ControllerPianta>();
    }

    public Scompartimento nuovoScompartimento() {
        try{
            return this.orto.aggiungiNuovoScompartimento(0.70);
        } catch (Exception ex){
            System.out.println("Errore! Non è stato possibile aggiungere lo scompartimento.");
        } finally {
            System.out.println("Aggiunto un nuovo scompartimento..");
        }
        return null;
    }

    //Aggiunge nella lista controllers i controller delle piante
    public void addListeners(ControllerPianta cp){
        try{
            this.controllers.add(cp);
        } catch (Exception e){
            System.out.println("Errore! \n "+ e );
        }
    }

    //Funzoioen per aggiornare nella view il tipo di pianta coltivato
    // Utilizzata nella classe Scompartimento
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
    
    public void raccogliPianta(int index){
        ControllerPianta listener = null; 
        try{
            listener = this.controllers.get(index);
        } catch (Exception e){
            System.out.println("[ControllerScompartimento.aggiornaPiantaInPanel]: "+e);
            System.out.println(this.controllers.size());
        }
        if(listener != null){
            listener.raccogliPianta();
        }
    }

    public void aggiungiOrtaggio(int index,Pianta p){
        this.orto.aggiungiPianta(index, p);
    }

    //Aggiorna la GUI quando c'è un cambiamento di stato della pianta
    public void aggiornaStato(int index,String nuovoStato) {
        ControllerPianta panelPianta = this.controllers.get(index);
        panelPianta.aggiornaStato(nuovoStato);
    }
}
