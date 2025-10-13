/**
 * Dado um tabuleiro de tamanho NxN, devemos colocar N rainhas no tabuleiro de forma
 * que nenhuma delas se ataquem.
 * 0 1 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 1 0
 */

public class NRainhas {

    public void executar( int numeroRainhas) {
        int x = numeroRainhas;
        int y = numeroRainhas;

        int[][] tabuleiro = new int[x][y];

        boolean resultado = resolveNRainhas(tabuleiro, numeroRainhas);
        if (resultado) {
            imprimirTabuleiro(tabuleiro);
        } else {
            IO.println("Não tem solução");
        }
    }

    private boolean resolveNRainhas(int[][] tab, int n){
        // checa se todas as rainhas foram colocadas
        if(n == 0){
            return true;
        }

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (temAtaque(i, j, tab)){
                    continue;
                }
                // colocando a rainha no tabuleiro
                tab[i][j] = 1;

                if (resolveNRainhas(tab, n - 1)) {
                    return true;
                }

                // Solução não foi encontrada, desfazendo a última mudança.
                tab[i][j] = 0;
            }
        }


        return false;
    }

    private boolean temAtaque(int x, int y, int[][] tab) {
        // checar pelas linhas e pelas colunas
        for(int j = 0; j < tab.length; j++){
            if(tab[x][j] == 1){
                return true;
            }
        }

        for(int i = 0; i < tab.length; i++){
            if(tab[i][y] == 1){
                return true;
            }
        }

        // Checando as diagonais.
        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab.length; j++){
                int indexEsquedo = i + j;
                int indexDireito = i - j;

                if(indexEsquedo == (x + y)){
                    if(tab[i][j] == 1){
                        return true;
                    }
                }
                if(indexDireito == (x - y)){
                    if(tab[i][j] == 1){
                        return true;
                    }
                }
            }
        }
        return false;
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
