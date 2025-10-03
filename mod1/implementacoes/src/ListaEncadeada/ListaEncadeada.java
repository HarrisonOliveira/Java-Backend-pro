package ListaEncadeada;

public class ListaEncadeada {
    private NodeCustom cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void push(NodeCustom node) {
        if (cabeca == null) {
            cabeca = node;
        } else {
            NodeCustom atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        node.proximo = null;
        tamanho++;
    }

    public NodeCustom pop() {
        if (cabeca == null) {
            throw new RuntimeException("Lista vazia! Não é possível remover elementos.");
        }

        NodeCustom removido;

        if (cabeca.proximo == null) {
            // Se há apenas um elemento
            removido = cabeca;
            cabeca = null;
        } else {
            // Navega até o penúltimo nó
            NodeCustom atual = cabeca;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            removido = atual.proximo;
            atual.proximo = null;
        }
        tamanho--;
        return removido;
    }


    public void insert(int index, NodeCustom node) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            // Inserir no início
            node.proximo = cabeca;
            cabeca = node;
        } else {
            // Navega até a posição anterior ao índice
            NodeCustom atual = cabeca;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
        }
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            // Remove do início
            cabeca = cabeca.proximo;
        } else {
            // Navega até a posição anterior ao índice
            NodeCustom atual = cabeca;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public NodeCustom elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        NodeCustom atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        if (cabeca == null) {
            System.out.println("Lista vazia: []");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lista: [");

        NodeCustom atual = cabeca;
        while (atual != null) {
            stringBuilder.append(atual.valor);
            if (atual.proximo != null) {
                stringBuilder.append(" -> ");
            }
            atual = atual.proximo;
        }

        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public void testaListaEncadeada() {
        IO.println("testando lista encadeada");
        push(new NodeCustom(10));
        push(new NodeCustom(20));
        push(new NodeCustom(30));
        printList();
        IO.println("Tamanho: " + size());
        insert(1, new NodeCustom(15));
        printList();
        NodeCustom elemento = elementAt(2);
        IO.println("Elemento no índice 2: " + elemento.valor);
        NodeCustom removido = pop();
        IO.println("Removido do fim: " + removido.valor);
        printList();
        remove(1);
        printList();
        IO.println("Tamanho final: " + size());
    }
}
