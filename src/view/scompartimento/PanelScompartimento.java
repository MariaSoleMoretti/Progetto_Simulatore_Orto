package view.scompartimento;

import java.awt.*;
import javax.swing.*;

public class PanelScompartimento extends JPanel{
    
    public PanelScompartimento() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 300));
        this.setLayout(new GridLayout(2, 2, 4, 4)); // 2 righe e 2 colonne

        // Aggiungi 4 istanze di PanelPianta
        for (int i = 0; i < 4; i++) {
            this.add(new PanelPianta());
        }
    }
}
