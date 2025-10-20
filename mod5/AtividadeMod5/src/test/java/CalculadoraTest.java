import com.ebac.calculadora.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void calculadoraTest_HappyPath() {
        Calculadora calculadora = new Calculadora();
        calculadora.somar(2, 2);
        calculadora.multiplicar(2, 2);
        calculadora.subtrair(10, 5);
        calculadora.dividir(10, 2);
    }

    @Test
    public void somaDoisNumeros_HappyPath(){
        Calculadora calculadora = new Calculadora();
        Integer resultado = calculadora.somar(2, 2);
        assertEquals(4, resultado);
    }
    @Test
    public void multiplicacaoDoisNumeros_HappyPath(){
        Calculadora calculadora = new Calculadora();
        Integer resultado = calculadora.multiplicar(5, 2);
        assertEquals(10, resultado);
    }

    @Test
    public void subtracaoDoisNumeros_HappyPath(){
        Calculadora calculadora = new Calculadora();
        Integer resultado = calculadora.subtrair(10, 5);
        assertEquals(5, resultado);
    }
    @Test
    public void divisaoDoisNumeros_HappyPath(){
        Calculadora calculadora = new Calculadora();
        Integer resultado = calculadora.dividir(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    public void validarSeEhZeroTest_ZeroTrue(){
        Calculadora calculadora = new Calculadora();
        boolean retorno = calculadora.validarSeEhZero(10, 0);
        assertTrue(retorno);
    }
    @Test
    public void validarSeEhZeroTest_ZeroFalse(){
        Calculadora calculadora = new Calculadora();
        boolean retorno = calculadora.validarSeEhZero(10, 10);
        assertFalse(retorno);
    }

    @Test
    public void divisaoDoisNumeros_NuloTrue(){
        Calculadora calculadora = new Calculadora();
        boolean retorno = calculadora.validarNaoNulo(10, null);
        assertTrue(retorno);
    }
    @Test
    public void divisaoDoisNumeros_NuloFalse(){
        Calculadora calculadora = new Calculadora();
        boolean retorno = calculadora.validarNaoNulo(10, 10);
        assertFalse(retorno);
    }
}
