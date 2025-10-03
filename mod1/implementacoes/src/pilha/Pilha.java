package pilha;

import java.util.Stack;

public class Pilha {

    private int[] elemento;

    private int topo;
    private int tamanho;

    public Pilha(int tamanho){
        this.tamanho = tamanho;
        this.elemento = new int[tamanho];
        this.topo = -1;
    }

    public void push(int elemento){
        if(topo == tamanho-1){
            System.out.println("Pilha está cheia");
        }else{
            topo++;
            this.elemento[topo] = elemento;
        }
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Pilha está vazia");
        }else {
            return elemento[topo--];
        }
    }

    public int top(){
        if (isEmpty()){
            throw new RuntimeException("Pilha está vazia");
        }
        return elemento[topo];
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public int size(){
        return topo + 1;
    }

    private void redimencionar(){
        tamanho *= 2;
        int[] novo = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            novo[i] = elemento[i];
        }
        elemento = novo;
    }

    public void testaPilha(){
        IO.println("Testando Pilha \n ");

        push(10);
        push(20);
        push(30);

        IO.println("Tamanho da pilha: " + size());
        IO.println("Topo da pilha: " + top());

        IO.println("Removendo: " + pop());
        IO.println("Removendo: " + pop());
        IO.println("Removendo: " + pop());

        IO.println("Pilha está vazia? " + isEmpty());
    }

}
