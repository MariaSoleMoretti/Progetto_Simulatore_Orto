package view.scompartimento;

import java.awt.*;
import java.util.EventListener;

import javax.swing.*;

public class PanelPianta extends JPanel implements EventListener{
    private JLabel tipoPianta = new JLabel("Vuoto");
    
    public PanelPianta(){
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());
        // Imposto dimensioni fisse dello slot
        this.setPreferredSize(new Dimension(100, 100));
        // Imposto l'allineamento orizzontale della label al centro
        tipoPianta.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(tipoPianta, BorderLayout.CENTER);
    }

    //Invocato quando viene aggiunta una pianta allo slot
    public void aggiungiPianta(String tipoPianta){
        this.tipoPianta.setText(tipoPianta);
    }
}
