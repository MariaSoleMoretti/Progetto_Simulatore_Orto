package utils;
import java.util.Set;
import model.Scompartimento;

public class MyUtils {
    static public void notifyPioggia(Set<Scompartimento> listeners){
        try{
            for (Scompartimento s : listeners) {
            s.resetUmidità();
        }
    } catch (NullPointerException e){
        System.out.println("Non ci sono scompartimenti da innaffiare!");
    }
    }
}
