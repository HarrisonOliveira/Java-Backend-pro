import Fila.Fila;
import ListaEncadeada.ListaEncadeada;
import pilha.Pilha;

void main() {
    Pilha pilha = new Pilha(5);
    ListaEncadeada listaEncadeada = new ListaEncadeada();
    Fila fila = new Fila(5);

    IO.println("----------------------- \n");
    pilha.testaPilha();
    IO.println("----------------------- \n");
    listaEncadeada.testaListaEncadeada();
    IO.println("----------------------- \n");
    fila.testaFila();
    IO.println("----------------------- \n");
}
