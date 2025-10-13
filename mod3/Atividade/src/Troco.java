import java.util.*;

public class Troco {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        System.out.println("ALGORITMO DE TROCO - MENOR NÚMERO DE MOEDAS");
        System.out.println("=".repeat(50));
        System.out.println();

        // Exemplo 1: Do enunciado
        System.out.println("EXEMPLO 1:");
        int[] moedas1 = {5, 2, 1};
        ResultadoTroco resultado1 = calcularTrocoMinimo(18, moedas1);
        exibirResultado(18, moedas1, resultado1);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Exemplo 2: Moedas do Real
        System.out.println("EXEMPLO 2:");
        int[] moedas2 = {25, 10, 5, 1};
        ResultadoTroco resultado2 = calcularTrocoMinimo(37, moedas2);
        exibirResultado(37, moedas2, resultado2);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Exemplo 3: Caso impossível
        System.out.println("EXEMPLO 3:");
        int[] moedas3 = {5, 3};
        ResultadoTroco resultado3 = calcularTrocoMinimo(11, moedas3);
        exibirResultado(11, moedas3, resultado3);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Exemplo 4: Teste personalizado
        System.out.println("TESTE PERSONALIZADO:");
        int[] moedas4 = {25, 10, 5, 1};
        ResultadoTroco resultado4 = calcularTrocoMinimo(63, moedas4);
        exibirResultado(63, moedas4, resultado4);
    }

    public static ResultadoTroco calcularTrocoMinimo(int quantia, int[] moedas) {
        // Programação dinâmica para encontrar a solução ótima
        // dp[i] representa o número mínimo de moedas para quantia i
        int[] dp = new int[quantia + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 moedas necessárias para quantia 0

        // parent[i] guarda qual moeda foi usada para chegar na quantia i
        int[] parent = new int[quantia + 1];
        Arrays.fill(parent, -1);

        // Preenche a tabela dp
        for (int i = 1; i <= quantia; i++) {
            for (int moeda : moedas) {
                if (moeda <= i && dp[i - moeda] != Integer.MAX_VALUE) {
                    if (dp[i - moeda] + 1 < dp[i]) {
                        dp[i] = dp[i - moeda] + 1;
                        parent[i] = moeda;
                    }
                }
            }
        }

        // Se não for possível dar o troco exato
        if (dp[quantia] == Integer.MAX_VALUE) {
            return null;
        }

        // Reconstrói a solução
        Map<Integer, Integer> moedasUsadas = new HashMap<>();
        int valorAtual = quantia;

        while (valorAtual > 0) {
            int moedaUsada = parent[valorAtual];
            moedasUsadas.put(moedaUsada, moedasUsadas.getOrDefault(moedaUsada, 0) + 1);
            valorAtual -= moedaUsada;
        }

        return new ResultadoTroco(dp[quantia], moedasUsadas);
    }

    public static void exibirResultado(int quantia, int[] moedas, ResultadoTroco resultado) {
        System.out.println("Quantia: " + quantia);
        System.out.print("Moedas disponíveis: [");
        Arrays.sort(moedas);
        for (int i = moedas.length - 1; i >= 0; i--) {
            System.out.print(moedas[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("-".repeat(50));

        if (resultado == null) {
            System.out.println("Não é possível dar o troco exato com essas moedas!");
            return;
        }

        System.out.println("Número mínimo de moedas: " + resultado.numeroMoedas);
        System.out.println("\nDetalhamento:");

        // Ordena as moedas em ordem decrescente para exibição
        List<Integer> moedasOrdenadas = new ArrayList<>(resultado.moedasUsadas.keySet());
        moedasOrdenadas.sort(Collections.reverseOrder());

        for (int moeda : moedasOrdenadas) {
            int qtd = resultado.moedasUsadas.get(moeda);
            System.out.println(" - " + qtd + " moeda(s) de " + moeda);
        }

        // Verificação
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : resultado.moedasUsadas.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        System.out.println("\nVerificação: " + total + " = " + quantia + " : Sim");
    }

    static class ResultadoTroco {
        int numeroMoedas;
        Map<Integer, Integer> moedasUsadas;

        public ResultadoTroco(int numeroMoedas, Map<Integer, Integer> moedasUsadas) {
            this.numeroMoedas = numeroMoedas;
            this.moedasUsadas = moedasUsadas;
        }
    }


}


