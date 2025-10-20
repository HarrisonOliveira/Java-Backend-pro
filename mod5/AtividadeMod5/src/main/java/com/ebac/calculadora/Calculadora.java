package com.ebac.calculadora;

public class Calculadora {


    /**
     * @return Retorna a soma de dois números inteiros se nenhum deles for nulo.
     */
    public Integer somar(Integer n1, Integer n2) {
        validarNaoNulo(n1, n2);
        imprimirResultado("soma", n1 + n2);
        return n1 + n2;
    }
    /**
     * @return Retorna a multiplicação de dois números inteiros se nenhum deles for nulo.
     */
    public Integer multiplicar(Integer n1, Integer n2) {
        validarNaoNulo(n1, n2);
        int multiplica = n1 * n2;
        imprimirResultado("multiplicação", multiplica);
        return n1 * n2;
    }

    /**
     * @return Retorna a subtração de dois números inteiros se nenhum deles for nulo.
     */
    public Integer subtrair(Integer n1, Integer n2) {
        validarNaoNulo(n1, n2);
        imprimirResultado("subtração", n1 - n2);
        return n1 - n2;
    }
    /**
     * @return Retorn a divisão de dois números inteiros se nenhum deles for nulo ou igual a zero.
     */
    public Integer dividir (Integer n1, Integer n2) {
        validarNaoNulo(n1, n2);
        validarSeEhZero(n1, n2);
        imprimirResultado("divisão", n1 / n2);
        return n1 / n2;

    }
    /**
     * Verifica se n1 ou n2 é igual a zero.
     */
    public Boolean validarSeEhZero(Integer n1, Integer n2) {
        return n1 == 0 || n2 == 0;
    }

    /**
     * Verifica se os valores de n1 ou n2 não são nulos.
     */
    public boolean validarNaoNulo(Integer n1, Integer n2){
        return n1 == null || n2 == null;
    }

    private void imprimirResultado(String operacao, Integer resultado){
        IO.println("A " + operacao + " do número n1 e o número n2 é igual a: " + resultado);
    }
}
