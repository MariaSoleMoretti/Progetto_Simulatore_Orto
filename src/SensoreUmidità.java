
public class SensoreUmidità {

    private Meteo meteo;
    private double sogliaMin;
    private double sogliaMax;

    //Costruttore
    public SensoreUmidità(Meteo m, double min, double max){
        this.meteo = m;
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
