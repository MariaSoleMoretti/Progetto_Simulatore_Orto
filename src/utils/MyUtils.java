package utils;
import java.util.*;
import model.Scompartimento;

public class MyUtils {
    // ----------------------------------------------
    //  Setta il valore di umidità al valore massimo
    // ----------------------------------------------
    static public void notifyIrrigazione(List<Scompartimento> listeners){
        try{
            for (Scompartimento s : listeners) {
            s.resetUmidità();
        }
    } catch (NullPointerException e){
        System.out.println("[MyUtils]: Non ci sono listeners da notificare: "+e);
    }
    }
}
