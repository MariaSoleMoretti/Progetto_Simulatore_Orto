package controller;

import model.OrtoSmart;
import model.piante.Pianta;
import view.scompartimento.PanelPianta;

public class ControllerPianta {
    final OrtoSmart orto = OrtoSmart.getInstance();
    private PanelPianta listenerPanel;             //Lista di PanelPianta per ppoter aggiornare la view quando si aggiorna il model

    public ControllerPianta(PanelPianta p){
        this.listenerPanel = p;
    }

    //Aggiunge un PanelPianta alla lista dei listeners nel momento della creazione dello Scompartimento
    public void addListener(PanelPianta p){
        this.listenerPanel = p;
    }

    //Funzoioen per aggiornare nella view il tipo di pianta coltivato
    public void aggiornaPiantaInPanel(Pianta pianta){
        listenerPanel.aggiungiPianta(pianta);
    } 
    
    public void raccogliPianta(){
        listenerPanel.resetSlot();
    }

    public void aggiungiOrtaggio(int index,Pianta p){
        this.orto.aggiungiPianta(index, p);
    }

    //Aggiorna la GUI quando c'è un cambiamento di stato della pianta
    public void aggiornaStato(String nuovoStato) {
        listenerPanel.aggiornaStato(nuovoStato);
    }
}
