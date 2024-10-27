package view.scompartimento;

import java.awt.*;
import java.util.EventListener;

import javax.swing.*;

import model.piante.Pianta;

public class PanelPianta extends JPanel implements EventListener{
    private JLabel tipoPianta = new JLabel("Vuoto");
    private JLabel stato = new JLabel("Stato: ");
    private JLabel umidità = new JLabel("Umidità: 0%");
    
    public PanelPianta(){
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());
        // Imposto dimensioni fisse dello slot e bordi interni
        this.setPreferredSize(new Dimension(200, 100));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Imposto l'allineamento orizzontale della label al centro
        tipoPianta.setHorizontalAlignment(SwingConstants.CENTER);
        //Aggiungo gli elementi del panel contenenti le informazioni dela pianta
        this.add(tipoPianta, BorderLayout.NORTH);
        this.add(stato, BorderLayout.CENTER);
        this.add(umidità, BorderLayout.SOUTH);
    }

    //Invocato quando viene aggiunta una pianta allo slot
    public void aggiungiPianta(Pianta pianta){
        this.tipoPianta.setText(pianta.getNome());
        this.stato.setText("Stato: "+pianta.getStatoCrescita().toString());
        this.umidità.setText(pianta.getValUmidità()*100+"%");
    }

    //Invocato quando cambia lo stato della crescita della pianta
    public void aggiornaStato(String stato){
        SwingUtilities.invokeLater(() -> {
            this.stato.setText("Stato: "+stato);
            this.revalidate();
            this.repaint();
        });
    }

    public void resetSlot() {
        SwingUtilities.invokeLater(() -> {
            this.tipoPianta.setText("Vuoto");
            this.stato.setText("Stato:");
            this.umidità.setText("Umidita: 0%");
            this.revalidate();
            this.repaint();
        });
    }
}
