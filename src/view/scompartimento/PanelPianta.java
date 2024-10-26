package view.scompartimento;

import java.awt.*;
import java.util.EventListener;

import javax.swing.*;

public class PanelPianta extends JPanel implements EventListener{
    private JLabel tipoPianta = new JLabel("Vuoto");
    private JLabel stato = new JLabel("Stato: ");
    private JLabel umidità = new JLabel("Umidità: 0%");
    
    public PanelPianta(){
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());
        // Imposto dimensioni fisse dello slot e bordi interni
        this.setPreferredSize(new Dimension(100, 100));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Imposto l'allineamento orizzontale della label al centro
        tipoPianta.setHorizontalAlignment(SwingConstants.CENTER);
        //Aggiungo gli elementi del panel contenenti le informazioni dela pianta
        this.add(tipoPianta, BorderLayout.NORTH);
        this.add(stato, BorderLayout.CENTER);
        this.add(umidità, BorderLayout.SOUTH);
    }

    //Invocato quando viene aggiunta una pianta allo slot
    public void aggiungiPianta(String tipoPianta){
        this.tipoPianta.setText(tipoPianta);
    }

    //Invocato quando cambia lo stato della crescita della pianta
    public void aggiornaStato(String stato){
        this.stato.setText(stato);
    }
}
