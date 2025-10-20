package com.ebac.fibonacci;

import java.math.BigDecimal;

/**
 * Classe que implementa o cálculo da sequência de Fibonacci usando programação dinâmica (memoization)
 * para otimizar o desempenho evitando recálculos de valores já processados.
 * Utiliza BigDecimal para suportar valores arbitrariamente grandes sem limitações de overflow.
 */
public class Fibonacci {
    /**
     * Define o limite máximo de elementos que podem ser calculados.
     */
    private int MAX_ELEMENTOS = 100;

    /**
     * Array que armazena os valores já calculados da sequência de Fibonacci para evitar recálculos (memoization).
     * Utiliza BigDecimal para suportar valores arbitrariamente grandes.
     */
    private BigDecimal[] elementoFib = new BigDecimal[MAX_ELEMENTOS];

    /**
     * Método público que inicializa o processo de cálculo usando programação dinâmica.
     *
     * @param n posição do elemento na sequência de Fibonacci
     * @return valor do elemento na posição n.
     * @throws IllegalArgumentException se n excede o limite máximo
     */
    public BigDecimal encontrarElementoPD(int n) {
        if (n >= MAX_ELEMENTOS) {
            throw new IllegalArgumentException("Posição " + n + " excede o limite máximo de " + (MAX_ELEMENTOS - 1));
        }

        for (int i = 0; i < MAX_ELEMENTOS; i++){
            elementoFib[i] = null;
        }
        return encontrarElemento(n);
    }

    /**
     * Método privado recursivo que calcula o n-ésimo elemento da sequência de Fibonacci.
     * Utiliza memoization para armazenar valores já calculados.
     *
     * @param n posição do elemento
     * @return valor do elemento na posição n.
     */
    public BigDecimal encontrarElemento(int n) {
        if (elementoFib[n] == null) {
            if(n <= 1){
                elementoFib[n] = BigDecimal.valueOf(n);
            } else {
                elementoFib[n] = encontrarElemento(n - 1).add(encontrarElemento(n - 2));
            }
        }
        return elementoFib[n];
    }

    /**
     * Método público de conveniência para executar e exibir o resultado do cálculo de Fibonacci.
     *
     * @param n posição do elemento na sequência de Fibonacci
     */
    public void executarFibonacci(int n) {
        IO.println("Elemento na posição " + n + " é " + encontrarElementoPD(n));
    }
}
