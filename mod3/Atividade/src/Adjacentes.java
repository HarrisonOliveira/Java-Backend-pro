import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adjacentes {
    public static void main(String[] args) {
        int[] s1 = {1, 2, 3};
        int n1 = 2;
        System.out.println("Entrada: S = " + Arrays.toString(s1) + ", n = " + n1);
        System.out.println("Saída: " + calcularSubconjuntos(s1, n1));
        System.out.println();

        int[] s2 = {1, 2, 3, 4};
        int n2 = 1;
        System.out.println("Entrada: S = " + Arrays.toString(s2) + ", n = " + n2);
        System.out.println("Saída: " + calcularSubconjuntos(s2, n2));
    }

    static List<List<Integer>> calcularSubconjuntos(int[] s, int n) {
        List<List<Integer>> resultado = new ArrayList<>();

        if (n < 0 || n > s.length) {
            return resultado;
        }

        combinar(s, n, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    static void combinar(int[] s, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        // Caso base: se já temos n elementos, adiciona ao resultado
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        // Para cada elemento a partir do índice inicio
        for (int i = inicio; i < s.length; i++) {
            // Adiciona o elemento atual
            atual.add(s[i]);

            // Recursão para adicionar os próximos elementos
            combinar(s, n, i + 1, atual, resultado);

            // Remove o último elemento (backtracking)
            atual.removeLast();
        }
    }
}
