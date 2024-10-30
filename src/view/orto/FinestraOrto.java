package view.orto;

import java.awt.*;

import javax.swing.*;

public class FinestraOrto extends JFrame{

    public FinestraOrto(){
        // Creo il frame e imposto titolo e altre proprieta'
       this.setTitle("Orto Smart");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Aggiunge al frame il pulsante per aggiungere un nuovo scompartimento
       this.add(new BottoneNuovoScomp(),BorderLayout.CENTER );
       //this.add(new PanelTotale(),BorderLayout.SOUTH);

        //Adatto le dimensioni del frame ai componenti e disabilito il ridimensionamento
        this.setSize(200, 100);
        this.setResizable(false);

        // Alla fine rendo visible il JFrame
        this.setVisible(true);
    }
}
