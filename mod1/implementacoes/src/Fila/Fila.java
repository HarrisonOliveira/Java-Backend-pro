package Fila;

public class Fila {
    private int[] elemento;
    private int index;
    private int inicio;

    public Fila(int tamanho){
        this.elemento = new int[tamanho];
        this.index = 0;
        this.inicio = 0;
    }

    public void enqueue(int elemento){
        this.elemento[index] = elemento;
        index++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("A fila está vazia");
        } else {
            return elemento[inicio++];
        }
    }

    public int rear(){
        if (isEmpty()){
            throw new RuntimeException("A fila está vazia");
        }
        return elemento[index - 1];
    }

    public int front(){
        return elemento[inicio];
    }

    public int size(){
        return index - inicio;
    }

    public boolean isEmpty(){
        return inicio == index;
    }

    public void testaFila() {
        IO.println("Testando Fila \n ");

        enqueue(10);
        enqueue(20);
        enqueue(30);

        IO.println("Tamanho da fila: " + size());
        IO.println("Primeiro elemento na fila: " + front());
        IO.println("Ultimo elemento da fila: " + rear());
        IO.println("Removido elemento: " + dequeue() + " da fila" + "\nProximo elemento da fila: " + front() + "\n");
        IO.println("Removido elemento: " + dequeue() + " da fila" + "\nProximo elemento da fila: " + front() + "\n");
        IO.println("Removido elemento: " + dequeue() + " da fila \n");

        IO.println("A fila está vazia? " + isEmpty());
    }
}
