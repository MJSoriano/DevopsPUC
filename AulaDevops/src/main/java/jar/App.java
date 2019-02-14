package jar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Carta> mao1 = new ArrayList<Carta>();

        mao1.add(new Carta(2,"3","C"));
        mao1.add(new Carta(3,"4","S"));
        mao1.add(new Carta(5,"6","D"));
        mao1.add(new Carta(1,"2","H"));
        mao1.add(new Carta(4,"5","C"));

        for (Carta c : mao1) {
            System.out.println(c.getPeso());
        }
        
        ordenarMao(mao1);

        System.out.println("-------------------------------------------");

        for (Carta c : mao1) {
            System.out.println(c.getPeso());
        }

    }

    public static void ordenarMao(List<Carta> mao) {
        Collections.sort(mao, new Comparator<Carta>() {
            public int compare(Carta s1, Carta s2) {
                return s1.getPeso().compareTo(s2.getPeso());
            }
        });
    }

}
