package view.orto;

import javax.swing.*;
import java.util.*;

import model.*;
import view.scompartimento.FinestraScompartimento;

public class FinestraOrto extends JFrame{

    private OrtoSmart orto = OrtoSmart.getInstance();
    private List<FinestraScompartimento> scompartimenti;    //Lisra contenete i frame degli scompartimenti

    public FinestraOrto(){
        // Creo il frame e imposto titolo e altre proprieta'
       this.setTitle("Orto");

       //Aggiunge al frame il pulsante per aggiungere un nuovo scompartimento
       this.add(new BottoneNuovoScomp(null, null));

       //Nel momento dell'avvio del programma viene creato uno scompartimento
       nuovaFinestra();

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        this.pack();
        this.setResizable(false);

        // Alla fine rendo visible il JFrame
        this.setVisible(true);
    }

    private void nuovaFinestra(){
        this.scompartimenti = new LinkedList<FinestraScompartimento>();
        this.scompartimenti.add(new FinestraScompartimento());
    }

    public static void main(String[] args){
        new FinestraOrto();
    }
}
