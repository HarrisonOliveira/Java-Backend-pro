import java.math.BigDecimal;

public class FatorialBigDecimal {

    private final int MAX_ELEMENTOS = 1000; // BigDecimal não tem limite de overflow, mas limitamos o cache
    private final BigDecimal[] fatorialCache = new BigDecimal[MAX_ELEMENTOS];

    private BigDecimal calcularFatorialPD(int n) {
        // Validação de entrada
        if (n < 0) throw new IllegalArgumentException("Não é possível calcular fatorial de número negativo");
        if (n > MAX_ELEMENTOS) throw new IllegalArgumentException("Número " + n + " excede o limite máximo de " + (MAX_ELEMENTOS));

        // Inicializa o cache
        for (int i = 0; i < MAX_ELEMENTOS; i++) fatorialCache[i] = null;
        return calcularFatorial(n);
    }

    private BigDecimal calcularFatorial(int n) {
        // Se ainda não foi calculado
        if (fatorialCache[n] == null) {
            if (n <= 1) {
                // Caso base: 0! = 1 e 1! = 1
                fatorialCache[n] = BigDecimal.ONE;
            } else {
                // Caso recursivo: n! = n × (n-1)!
                fatorialCache[n] = BigDecimal.valueOf(n).multiply(calcularFatorial(n - 1));
            }
        }
        return fatorialCache[n];
    }

    public void executarBigFatorial(int n) {
        IO.println("Fatorial de " + n + " é " + calcularFatorialPD(n));
    }
}
