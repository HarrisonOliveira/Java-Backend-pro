# README - Estruturas de Dados e Análise de Complexidade

## 📊 Análise de Complexidade Assintótica

Este documento apresenta a análise detalhada da complexidade de tempo e espaço das estruturas de dados implementadas neste projeto.

---

## 🔴 PILHA (Stack)

### Implementação
Pilha implementada com **array estático**.

### Complexidade de Tempo

| Operação           | Complexidade | Justificativa                                                                                    |
|--------------------|--------------|--------------------------------------------------------------------------------------------------|
| **push(elemento)** | **O(1)**     | Acesso direto ao índice `topo` do array. Apenas incrementa o índice e insere o elemento.         |
| **pop()**          | **O(1)**     | Acesso direto ao índice `topo` do array. Remove e decrementa o índice em uma operação constante. |

### Complexidade de Espaço

| Aspecto             | Complexidade | Justificativa                                                                                   |
|---------------------|--------------|-------------------------------------------------------------------------------------------------|
| **Espaço Total**    | **O(n)**     | Onde `n` é o tamanho do array alocado. O array ocupa espaço proporcional ao seu tamanho máximo. |
| **Espaço Auxiliar** | **O(1)**     | Apenas variáveis de controle (`topo`, `tamanho`) são utilizadas.                                |

---

## 🟢 FILA (Queue)

### Implementação
Fila implementada com **array estático** e controle de índices `inicio` e `index`.

### Complexidade de Tempo

| Operação              | Complexidade | Justificativa                                                                         |
|-----------------------|--------------|---------------------------------------------------------------------------------------|
| **enqueue(elemento)** | **O(1)**     | Insere o elemento no índice `index` e incrementa. Operação de acesso direto ao array. |
| **dequeue()**         | **O(1)**     | Remove o elemento no índice `inicio` e incrementa. Acesso direto ao array.            |
| **rear()**            | **O(1)**     | Retorna o elemento em `elemento[index - 1]`. Acesso direto, sem iterações.            |
| **front()**           | **O(1)**     | Retorna o elemento em `elemento[inicio]`. Acesso direto ao array.                     |

### Complexidade de Espaço

| Aspecto             | Complexidade | Justificativa                                                    |
|---------------------|--------------|------------------------------------------------------------------|
| **Espaço Total**    | **O(n)**     | Onde `n` é o tamanho do array alocado.                           |
| **Espaço Auxiliar** | **O(1)**     | Apenas variáveis de controle (`inicio`, `index`) são utilizadas. |

---

## 🔵 LISTA ENCADEADA (Linked List)

### Implementação
Lista encadeada simples com `Nós` contendo referência para o próximo elemento.

### Complexidade de Tempo

| Operação                | Complexidade | Justificativa                                                                                            |
|-------------------------|--------------|----------------------------------------------------------------------------------------------------------|
| **push(node)**          | **O(n)**     | Percorre toda a lista até encontrar o último nó `while (atual.proximo != null)`, depois insere no final. |
| **pop()**               | **O(n)**     | Percorre até o **penúltimo** nó para remover o último elemento da lista.                                 |
| **insert(index, node)** | **O(n)**     | No pior caso (inserção no final), percorre `n-1` nós. No melhor caso (inserção no início), é O(1).       |
| **remove(index)**       | **O(n)**     | No pior caso (remoção no final), percorre `n-1` nós para ajustar ponteiros.                              |
| **elementAt(index)**    | **O(n)**     | Percorre a lista sequencialmente até alcançar o índice desejado.                                         |

### Complexidade de Espaço

| Aspecto             | Complexidade | Justificativa                                                                                        |
|---------------------|--------------|------------------------------------------------------------------------------------------------------|
| **Espaço Total**    | **O(n)**     | Onde `n` é o número de elementos. Cada elemento ocupa espaço para o valor e o ponteiro `proximo`.    |
| **Espaço Auxiliar** | **O(1)**     | As operações usam apenas variáveis temporárias (`atual`, índices), independente do tamanho da lista. |


## 🎯 Quando Usar Cada Estrutura?

### Use **Pilha** quando:
- ✅ Precisar de acesso LIFO (Last In, First Out)
- ✅ Operações apenas no topo
- ✅ Exemplos: desfazer/refazer, navegação de histórico, avaliação de expressões

### Use **Fila** quando:
- ✅ Precisar de acesso FIFO (First In, First Out)
- ✅ Processamento em ordem de chegada
- ✅ Exemplos: fila de impressão, processamento de tarefas, BFS em grafos

### Use **Lista Encadeada** quando:
- ✅ Precisar de inserções/remoções frequentes em qualquer posição
- ✅ Tamanho dinâmico (sem necessidade de pré-alocar memória)
- ✅ Não precisar de acesso aleatório rápido
- ✅ Exemplos: implementação de outras estruturas, listas de adjacência em grafos


