package utils;
import java.util.*;
import model.Scompartimento;

public class MyUtils {
    
    static public void notifyPioggia(List<Scompartimento> listeners){
        try{
            for (Scompartimento s : listeners) {
            s.resetUmidità();
        }
    } catch (NullPointerException e){
        System.out.println(e);
    }
    }
}
