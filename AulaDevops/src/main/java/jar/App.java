package jar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Random r = new Random();

        List<Integer> pesos = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<String> valores = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "Ás");
        List<String> naipes = Arrays.asList("D", "H", "S", "C");
        List<Carta> mao1 = new ArrayList<Carta>();
        List<Carta> mao2 = new ArrayList<Carta>();

        Collections.shuffle(pesos);

        // Gera Mao1 de forma aleatoria
        for(int i=0; i < 5; i++) {
            Integer peso = pesos.get(i);
            String valor = valores.get(peso);
            mao1.add(new Carta(peso, valor, naipes.get(r.nextInt(naipes.size()))));
        }

        Collections.shuffle(pesos);

        // Gera Mao2 de forma aleatoria
        for(int i=0; i < 5; i++) {
            Integer peso = pesos.get(i);
            String valor = valores.get(peso);
            mao2.add(new Carta(peso, valor, naipes.get(r.nextInt(naipes.size()))));
        }

        // Ordena a Mao1 e Mao2
        ordenarMao(mao1);
        ordenarMao(mao2);

        System.out.println("--------------------- Mao 1 ---------------------");

        for (Carta c : mao1) {
            System.out.println(c);
        }

        System.out.println("--------------------- Mao 2 ---------------------");

        for (Carta c : mao2) {
            System.out.println(c);
        }
        
        System.out.println("--------------------- Verifica Straight Flush Mao 1  ---------------------");
        System.out.println(verificaStraightFlush(mao1));

        System.out.println("--------------------- Verifica Straight Flush Mao 2  ---------------------");
        System.out.println(verificaStraightFlush(mao1));

    }

    // Ordena a Mao do jogador pelo Peso da carta
    public static void ordenarMao(List<Carta> mao) {
        Collections.sort(mao, new Comparator<Carta>() {
            public int compare(Carta s1, Carta s2) {
                return s1.getPeso().compareTo(s2.getPeso());
            }
        });
    }

    // Verifica se ocorreu um Straight Flush
    public static Boolean verificaStraightFlush(List<Carta> mao) {
        for (int i = 0; i < mao.size() - 1; i++) {
            if ((mao.get(i + 1).getValor() != mao.get(i).getValor() + 1) && !mao.get(i + 1).getNaipe().equals(mao.get(i).getNaipe())) {
                return false;
            }
        }
        return true;
    }

}
