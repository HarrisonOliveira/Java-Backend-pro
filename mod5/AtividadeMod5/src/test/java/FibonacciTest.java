import com.ebac.fibonacci.Fibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para a classe Fibonacci.
 * Testa os cálculos da sequência de Fibonacci usando BigDecimal.
 */
public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    /**
     * Testa o caso base F(0) = 0
     */
    @Test
    public void testFibonacci0() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(0);
        assertEquals(BigDecimal.valueOf(0), resultado, "F(0) deve ser 0");
    }

    /**
     * Testa o caso base F(1) = 1
     */
    @Test
    public void testFibonacci1() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(1);
        assertEquals(BigDecimal.valueOf(1), resultado, "F(1) deve ser 1");
    }

    /**
     * Testa F(2) = 1
     */
    @Test
    public void testFibonacci2() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(2);
        assertEquals(BigDecimal.valueOf(1), resultado, "F(2) deve ser 1");
    }

    /**
     * Testa F(5) = 5
     */
    @Test
    public void testFibonacci5() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(5);
        assertEquals(BigDecimal.valueOf(5), resultado, "F(5) deve ser 5");
    }

    /**
     * Testa F(10) = 55
     */
    @Test
    public void testFibonacci10() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(10);
        assertEquals(BigDecimal.valueOf(55), resultado, "F(10) deve ser 55");
    }

    /**
     * Testa F(20) = 6765
     */
    @Test
    public void testFibonacci20() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(20);
        assertEquals(BigDecimal.valueOf(6765), resultado, "F(20) deve ser 6765");
    }

    /**
     * Testa valores maiores que os suportados por long (F(50))
     * F(50) = 12586269025
     */
    @Test
    public void testFibonacci50() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(50);
        assertEquals(new BigDecimal("12586269025"), resultado, "F(50) deve ser 12586269025");
    }

    /**
     * Testa valores muito grandes (F(90))
     * F(90) = 2880067194370816120
     */
    @Test
    public void testFibonacci90() {
        BigDecimal resultado = fibonacci.encontrarElementoPD(90);
        assertEquals(new BigDecimal("2880067194370816120"), resultado, "F(90) deve ser 2880067194370816120");
    }

    /**
     * Testa que uma exceção é lançada quando n excede o limite máximo
     */
    @Test
    public void testFibonacciExcedeLimite() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacci.encontrarElementoPD(100);
        }, "Deve lançar IllegalArgumentException quando n >= MAX_ELEMENTOS");
    }

    /**
     * Testa que uma exceção é lançada com valores muito acima do limite
     */
    @Test
    public void testFibonacciValorMuitoGrande() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacci.encontrarElementoPD(1000);
        }, "Deve lançar IllegalArgumentException para valores muito grandes");
    }

    /**
     * Testa múltiplas chamadas para garantir que a memoization funciona corretamente
     */
    @Test
    public void testMultiplasChamas() {
        BigDecimal resultado1 = fibonacci.encontrarElementoPD(10);
        BigDecimal resultado2 = fibonacci.encontrarElementoPD(10);
        assertEquals(resultado1, resultado2, "Múltiplas chamadas devem retornar o mesmo resultado");
    }

}
