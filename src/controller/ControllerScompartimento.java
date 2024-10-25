package controller;

import model.*;
import model.piante.Pianta;
import view.scompartimento.PanelPianta;

import java.awt.event.*;
import java.util.*;

public class ControllerScompartimento{

    final OrtoSmart orto = OrtoSmart.getInstance();
    private static ControllerScompartimento instance;
    private List<PanelPianta> listenersPanel;             //Lista di PanelPianta per ppoter aggiornare la view quando si aggiorna il model

    public static ControllerScompartimento getInstance() {
        if (instance == null) {
            instance = new ControllerScompartimento();
        }
        return instance;
    }

    public ControllerScompartimento(){
        this.listenersPanel = new ArrayList<PanelPianta>();
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

    //Aggiunge un PanelPianta alla lista dei listeners
    public void addListener(PanelPianta p){
        try{
            this.listenersPanel.add(p);
        } catch (Exception e){
            System.out.println("Errore! \n "+ e );
        }
    }

    //Funzoioen per aggiornare nella view il tipo di pianta coltivato
    // Utilizzata nella classe Scompartimento
    public void aggiornaPiantaInPanel(int index, String tipo){
        PanelPianta listener = null; 
        try{
            listener = this.listenersPanel.get(index);
        } catch (Exception e){
            System.out.println("[ControllerScompartimento.aggiornaPiantaInPanel]: "+e);
            System.out.println(this.listenersPanel.size());
        }
        if(listener != null){
            listener.aggiungiPianta(tipo);
        }
    }   

    public void aggiungiOrtaggio(int index,Pianta p){
        this.orto.aggiungiPianta(index, p);
    }
}
