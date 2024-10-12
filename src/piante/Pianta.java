package piante;
/*DESCRIZIONE CLASSE
 *  La seguente classe astratta definisce un comportamento comune a tutte la tipologie di piante che l'utente 
 *  può aggiungere al suo orto. 
 * 
 *  Definisce una serie di elementi comuni a tutte le piante come:
 *      - nome della pianta;
 *      - stagioni in cui la pianta si può coltivare;
 *      - range di umidità del suolo ottimale per la crescita della pianta.
 */

public abstract class Pianta {

    // Campi della classe
    private String nome;
    private String[] stagioni;
    private double umiditàMin;
    private double umiditàMax;
    private StatoCrescita statoCorrenteCrescita;

    //Costruttore
    public Pianta(String nome, String[] stagioni, double min, double max){
        this.nome = nome;
        this.stagioni = stagioni.clone();
        this.umiditàMin = min;
        this.umiditàMax = max;
        this.statoCorrenteCrescita = StatoCrescita.GERMINAZIONE;
    }

    // Metodi della classe
    public String getNome(){
        return this.nome;
    }

    public String[] getStagioni(){
        return this.stagioni.clone();
    }

    public double getUmiditàMin(){
        return this.umiditàMin;
    }

    public double getUmiditàMax(){
        return this.umiditàMax;
    }
    
    public StatoCrescita getStatoCrescita(){
        return this.statoCorrenteCrescita;
    }
    
    protected void setStatoCrescita(StatoCrescita nuovoStato){
        this.statoCorrenteCrescita = nuovoStato;
    }

    private void cambiaFaseCrescita(){
        this.statoCorrenteCrescita = this.statoCorrenteCrescita.successivo();
    }

    // ------------------------------------------------------------------------------
    //Metodo per aggiornare lo stato della crescita della pianta
    // ------------------------------------------------------------------------------
    protected void aggiornaStatoCrescita(){
        cambiaFaseCrescita();
        //System.out.println(this.statoCorrenteCrescita.toString());
    }

    // ------------------------------------------------------------------------------
    //Metodo per verificare se la pianta è pronta per essere raccolta
    // ------------------------------------------------------------------------------
    public boolean prontaDaRaccogliere(){
        return (this.statoCorrenteCrescita == StatoCrescita.SENESCENZA) ? true : false;
    } 
} 