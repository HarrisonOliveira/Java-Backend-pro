public class Fatorial {

    private final int MAX_ELEMENTOS = 21; // Fatorial de 20 é o maior que cabe em long
    private final long[] fatorialCache = new long[MAX_ELEMENTOS];

    private long calcularFatorialPD(int n) {
        // Validação de entrada
        if (n < 0) throw new IllegalArgumentException("Não é possível calcular fatorial de número negativo");
        if (n >= MAX_ELEMENTOS) throw new IllegalArgumentException("Número " + n + " excede o limite máximo de " + (MAX_ELEMENTOS - 1));

        // Inicializa o cache
        for (int i = 0; i < MAX_ELEMENTOS; i++) fatorialCache[i] = -1;
        return calcularFatorial(n);
    }

    private long calcularFatorial(int n) {
        // Se ainda não foi calculado
        if (fatorialCache[n] == -1) {
            if (n <= 1) {
                // Caso base: 0! = 1 e 1! = 1
                fatorialCache[n] = 1;
            } else {
                // Caso recursivo: n! = n × (n-1)!
                fatorialCache[n] = n * calcularFatorial(n - 1);
            }
        }
        return fatorialCache[n];
    }

    public void executarFatorial(int n) {
        IO.println("Fatorial de " + n + " é " + calcularFatorialPD(n));
    }
}