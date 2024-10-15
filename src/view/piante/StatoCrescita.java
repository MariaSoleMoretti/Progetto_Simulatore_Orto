package view.piante;

public enum StatoCrescita {
    GERMINAZIONE, FIORITURA, MATURAZIONE, SENESCENZA;

    public StatoCrescita successivo() {
        //System.out.println(this.toString());
        int ordinal = this.ordinal() + 1;
        if (ordinal < values().length) {
            return values()[ordinal];
        } else {
            // Gestisci il caso in cui si raggiunge lo stato finale
            return StatoCrescita.GERMINAZIONE; // O un altro valore appropriato
        }
    }
}