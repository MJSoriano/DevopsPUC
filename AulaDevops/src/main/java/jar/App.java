package jar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {       

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
}