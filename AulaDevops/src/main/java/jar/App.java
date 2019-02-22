package jar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Random r = new Random();

        List<Integer> pesos = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<String> valores = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "As");
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

        imprimeMaoTeste();

        System.out.println("--------------------- Verifica Straight Flush Mao 1  ---------------------");
        System.out.println(verificaStraightFlush(mao1));

        System.out.println("--------------------- Verifica Straight Flush Mao 2  ---------------------");
        System.out.println(verificaStraightFlush(mao2));

    }

    public static void imprimeMaoTeste() {
        List<Carta> maoTeste = new ArrayList<Carta>();
        maoTeste.add(new Carta(8,"10","H"));
        maoTeste.add(new Carta(9,"Vale","H"));
        maoTeste.add(new Carta(10,"Data","H"));
        maoTeste.add(new Carta(11,"Rei","H"));
        maoTeste.add(new Carta(12,"As","H"));

        ordenarMao(maoTeste);

        System.out.println("--------------------- Mao Teste ---------------------");
        for (Carta c : maoTeste) {
            System.out.println(c);
        }

        /* System.out.println("--------------------- Verifica Straight Flush Mao Teste  ---------------------");
        System.out.println(verificaStraightFlush(maoTeste)); */

        System.out.println("--------------------- Verifica Royal Flush Mao Teste  ---------------------");
        System.out.println(verificaRoyalFlush(maoTeste));
    }

    // Ordena a Mao do jogador pelo Peso da carta
    public static void ordenarMao(List<Carta> mao) {
        Collections.sort(mao, new Comparator<Carta>() {
            public int compare(Carta s1, Carta s2) {
                return s1.getPeso().compareTo(s2.getPeso());
            }
        });
    }

    // Verifica se na mao existe uma sequencia e se os naipes são iguais
    public static Boolean verificaSequenciaENaipe(List<Carta> mao) {
        for (int i = 0; i < mao.size() - 1; i++) {
            if ((mao.get(i + 1).getPeso() != mao.get(i).getPeso() + 1) || !mao.get(i + 1).getNaipe().equals(mao.get(i).getNaipe())) {
                return false;
            }
        }
        return true;
    }

    // Verifica se ocorreu um Straight Flush
    public static Boolean verificaStraightFlush(List<Carta> mao) {
        return verificaSequenciaENaipe(mao);
    }

    // Verifica se ocorreu um Royal Flush
    public static Boolean verificaRoyalFlush(List<Carta> mao) {
        if (mao.get(0).getPeso() == 8) {
            return verificaSequenciaENaipe(mao);
        }
        return false;
    }

    // Verifica se ocorreu uma Quadra
    public static Boolean verificaQuadra(List<Carta> mao) {
        List<Integer> pesos = new ArrayList<Integer>();
        for (Carta c : mao) {
            pesos.add(c.getPeso());
        }
        return !pesos.stream().filter(i -> Collections.frequency(pesos, i) == 4).collect(Collectors.toSet()).isEmpty();
    }

}
