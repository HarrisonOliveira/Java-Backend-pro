import javax.swing.text.AbstractDocument;

/**
 * Escrever um codigo chamado [encontrarElemento] que seja capaz de encontrar o enésimo elemento de uma
 * sequência de fibonacci.
 * Entrada: 'n', um inteiro representando a posição do elemento na sequência.
 * Saída: o enésimo elemento da sequência de Fibonacci.
 * Sequencia: 0 1 1 2 3 5 8 13 21 34 55 89
 */

public class Fibonacci {

    private int MAX_ELEMENTOS = 21;
    private long[] elementoFib = new long[MAX_ELEMENTOS];
    
    public long encontrarElementoPD(int n) {
        if (n >= MAX_ELEMENTOS) {
            throw new IllegalArgumentException("Posição " + n + " excede o limite máximo de " + (MAX_ELEMENTOS - 1));
        }

        for (int i = 0; i < MAX_ELEMENTOS; i++){
            elementoFib[i] = -1;
        }
        return encontrarElemento(n);
    }

    public long encontrarElemento(int n) {
        if (elementoFib[n] == -1) {
            if(n <= 1){
                elementoFib[n] = n;
            } else {
                elementoFib[n] = encontrarElemento(n - 1) + encontrarElemento(n - 2);
            }
        }
        return elementoFib[n];
    }

    public void executarFibonacci(int n) {
        IO.println("Elemento na posição " + n + " é " + encontrarElementoPD(n));
    }
}
