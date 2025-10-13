/**
 * Dado um tabuleiro de tamanho NxN, devemos colocar N rainhas no tabuleiro de forma
 * que nenhuma delas se ataquem.
 * 0 1 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 1 0
 */

public class NRainhasOtimizada {

    // Arrays para marcar colunas e diagonais ocupadas em O(1)
    private boolean[] colunasOcupadas;
    private boolean[] diagonalEsquerda;  // i + j
    private boolean[] diagonalDireita;   // i - j + (n-1)

    public void executar(int numeroRainhas) {
        int[][] tabuleiro = new int[numeroRainhas][numeroRainhas];

        // Inicializa arrays de controle
        colunasOcupadas = new boolean[numeroRainhas];
        diagonalEsquerda = new boolean[2 * numeroRainhas - 1];
        diagonalDireita = new boolean[2 * numeroRainhas - 1];

        boolean resultado = resolveNRainhas(tabuleiro, 0);
        if (resultado) {
            imprimirTabuleiro(tabuleiro);
        } else {
            IO.println("Não tem solução");
        }
    }

    private boolean resolveNRainhas(int[][] tab, int linha) {
        // Se todas as rainhas foram colocadas
        if (linha == tab.length) {
            return true;
        }

        // Tenta colocar rainha em cada coluna da linha atual
        for (int coluna = 0; coluna < tab.length; coluna++) {
            if (podePosicionar(linha, coluna, tab.length)) {
                // Marca posição como ocupada
                tab[linha][coluna] = 1;
                colunasOcupadas[coluna] = true;
                diagonalEsquerda[linha + coluna] = true;
                diagonalDireita[linha - coluna + (tab.length - 1)] = true;

                // Tenta resolver para a próxima linha
                if (resolveNRainhas(tab, linha + 1)) {
                    return true;
                }

                // Backtrack: desfaz marcações
                tab[linha][coluna] = 0;
                colunasOcupadas[coluna] = false;
                diagonalEsquerda[linha + coluna] = false;
                diagonalDireita[linha - coluna + (tab.length - 1)] = false;
            }
        }

        return false;
    }

    private boolean podePosicionar(int linha, int coluna, int n) {
        // Verifica em O(1) se a posição está sob ataque
        return !colunasOcupadas[coluna]
                && !diagonalEsquerda[linha + coluna]
                && !diagonalDireita[linha - coluna + (n - 1)];
    }

    private void imprimirTabuleiro(int[][] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                IO.print(tab[i][j]);
            }
            IO.println();
        }
    }
}
