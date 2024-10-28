package controller;

import java.awt.Color;

import model.OrtoSmart;
import model.piante.Pianta;
import view.scompartimento.PanelPianta;

public class ControllerPianta {
    final OrtoSmart orto = OrtoSmart.getInstance();     //Istanza singleton della classe OrtoSmart
    private PanelPianta listenerPanel;                  //Lista di PanelPianta per poter aggiornare la view quando si aggiorna il model

    public ControllerPianta(PanelPianta p){
        this.listenerPanel = p;
    }

    /**
    * Funzoione per aggiornare nella view il tipo di pianta coltivato
    *   @param pianta -> instanza della pianta da aggiungere tra i listeners
    */
    public void aggiornaPiantaInPanel(Pianta pianta){
        listenerPanel.aggiungiPianta(pianta);
    } 
    
    /**
     * Metodo per aggiurnare la view della pianta quando viene raccolta
    */
    public void raccogliPianta(){
        listenerPanel.resetSlot();
    }

    /**
     * Aggiorna la GUI quando c'è un cambiamento di stato della pianta
     *  @param nuovoStato -> Stringa contenente il nuovo stato della pianta
     */
    public void aggiornaStato(String nuovoStato) {
        listenerPanel.aggiornaStato(nuovoStato);
    }

    /**
     * Metodo per aggiurnare la view della pianta quando viene raccolta
     *  @param umidità -> nuovo valore di umidità
     *  @param min -> valore minimo di umidità della pianta.
     */
    public void notificaInnaffiare(double umidità, double min) {
        Color colore = (umidità < min)? Color.RED : Color.BLACK;
        var val = umidità*100;
        listenerPanel.bisognaInnaffiare((int)val,colore);
    }
}
