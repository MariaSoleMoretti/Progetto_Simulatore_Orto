package model;

public class SensoreUmidità {

    private Scompartimento scompartimento;
    private double sogliaMin;
    private double sogliaMax;

    //Costruttore
    public SensoreUmidità(Scompartimento sc, double min, double max){
        this.scompartimento = sc;
        this.sogliaMin = min;
        this.sogliaMax = max;
    }

    public double getSogliaMin(){
        return this.sogliaMin;
    }

    public double getSogliaMax(){
        return this.sogliaMax;
    }

    public void aggiornaUmidità(){

    }
}
