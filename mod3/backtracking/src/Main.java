//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    NRainhas nRainhas = new NRainhas();
    NRainhasOtimizada nRainhasOtimizada = new NRainhasOtimizada();

    long inicio = System.currentTimeMillis();
    nRainhas.executar(10);
    long fim = System.currentTimeMillis();

    System.out.println("\nTempo: " + (fim - inicio) + " ms");

    IO.print("------------------------------- \n");

    long init = System.currentTimeMillis();
    nRainhasOtimizada.executar(25);
    long fin = System.currentTimeMillis();

    System.out.println("\nTempo: " + (fin - init) + " ms");

}
