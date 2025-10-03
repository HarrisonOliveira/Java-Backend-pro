package ListaEncadeada;

public class NodeCustom {
    public int valor;
    NodeCustom proximo;

    public NodeCustom(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}