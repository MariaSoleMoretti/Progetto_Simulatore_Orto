package model;

public class SensoreUmidità {

    private double sogliaMin;
    private double sogliaMax;

    //Costruttore
    public SensoreUmidità(double min, double max){
        this.sogliaMin = min;
        this.sogliaMax = max;
    }

    public double getSogliaMin(){
        return this.sogliaMin;
    }

    public double getSogliaMax(){
        return this.sogliaMax;
    }

    public void aggiornaValoreUmidità(double val){

    }
}
