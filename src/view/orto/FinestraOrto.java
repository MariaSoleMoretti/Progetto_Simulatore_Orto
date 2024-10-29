package view.orto;

import javax.swing.*;

public class FinestraOrto extends JFrame{

    public FinestraOrto(){
        // Creo il frame e imposto titolo e altre proprieta'
       this.setTitle("Orto");

       //Aggiunge al frame il pulsante per aggiungere un nuovo scompartimento
       this.add(new BottoneNuovoScomp());

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        this.pack();
        this.setResizable(false);

        // Alla fine rendo visible il JFrame
        this.setVisible(true);
    }

    public static void main(String[] args){
        new FinestraOrto();
    }
}
