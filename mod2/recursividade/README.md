# Projeto Recursividade

## Descrição
Este projeto faz parte do curso **Java Backend Pro** da EBAC (Escola Britânica de Artes Criativas e Tecnologia), especificamente do **Módulo 2**. O objetivo deste projeto é explorar e implementar conceitos de **recursividade** em Java.

## Sobre Recursividade
Recursividade é uma técnica de programação onde uma função chama a si mesma para resolver um problema dividindo-o em subproblemas menores. É especialmente útil para resolver problemas que possuem uma estrutura naturalmente recursiva, como:
- Cálculo de fatorial
- Sequência de Fibonacci
- Travessia de árvores
- Algoritmos de busca e ordenação
- Problemas de divisão e conquista

## Estrutura do Projeto
```
recursividade/
├── src/
│   └── Main.java          # Classe principal do projeto
├── recursividade.iml      # Arquivo de configuração do IntelliJ IDEA
└── README.md              # Este arquivo
```

## Tecnologias Utilizadas
- **Java** (versão compatível com Java 21+, usando sintaxe moderna)
- **IntelliJ IDEA** (IDE recomendada)

## Como Executar
1. Certifique-se de ter o Java JDK instalado (versão 21 ou superior recomendada)
2. Abra o projeto no IntelliJ IDEA ou em sua IDE preferida
3. Navegue até o arquivo `src/Main.java`
4. Execute o método `main()`

### Via Linha de Comando
```bash
# Compile o projeto
javac src/Main.java

# Execute o programa
java -cp src Main
```

## Exemplos de Implementação
Este projeto pode incluir implementações de diversos algoritmos recursivos, tais como:

### Fatorial
```java
int fatorial(int n) {
    if (n <= 1) return 1;
    return n * fatorial(n - 1);
}
```

### Fibonacci
```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### Soma de Array
```java
int somaArray(int[] arr, int index) {
    if (index >= arr.length) return 0;
    return arr[index] + somaArray(arr, index + 1);
}
```

## Conceitos Importantes
- **Caso Base**: Condição que para a recursão
- **Caso Recursivo**: Chamada da função a si mesma
- **Stack Overflow**: Erro que ocorre quando há muitas chamadas recursivas
- **Otimização**: Uso de memoization ou recursão de cauda quando apropriado

## Autor
Projeto desenvolvido como parte do curso Java Backend Pro - EBAC

## Curso
**EBAC - Escola Britânica de Artes Criativas e Tecnologia**  
Curso: Java Backend Pro  
Módulo: 2 - Recursividade

---

## Status do Projeto
🚧 Em desenvolvimento

## Contribuições
Este é um projeto educacional. Sugestões e melhorias são bem-vindas!
