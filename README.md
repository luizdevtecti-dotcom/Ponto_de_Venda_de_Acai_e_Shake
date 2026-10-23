# Cumbe Açaí e Shake - Ponto de Venda

Trabalho de Java feito por Irely (IFBA, campus Euclides da Cunha).
Disciplina/professor: (preencher)

## O que é

Um sistema de ponto de venda que roda no terminal, para uma loja de açaí e shake.
O atendente escolhe os produtos no menu, finaliza o pedido e vê quanto o cliente
tem que pagar. No fim do dia, fecha o caixa e vê o total vendido.

## Como o sistema funciona

Menu principal:

- 0 - Fechar caixa: mostra o total de vendas e encerra o programa
- 1 - Pedir açaí
- 2 - Pedir shake
- 3 - Finalizar pedido: mostra o valor a pagar e volta pro menu

Regras da loja:

- Açaí vem em 300ml ou 500ml, e o tamanho muda o preço
- Açaí pode ter de 0 a 3 complementos, e cada um soma no preço
- Shake tem só 500ml, com leite de vaca ou de coco (o leite não muda o preço)
- O sabor do shake muda o preço
- Shake pode ter de 0 a 2 frutas, e cada uma soma no preço

Tabela de preços que eu usei (o enunciado não deu valores, então inventei):

| Item | Preço |
|---|---|
| Açaí 300ml | R$ 5,20 |
| Açaí 500ml | R$ 7,50 |
| Complemento (cada) | R$ 2,50 |
| Shake Oreo | R$ 6,00 |
| Shake OvoMaldini | R$ 6,00 |
| Fruta (cada) | R$ 3,79 |

## Classes

- `Sobremesa`: classe abstrata, guarda nome, tamanho e preço base. Tem o método
  abstrato `calcularPreco()`.
- `Acai`: filha de Sobremesa. Escolhe o preço pelo tamanho e soma os complementos.
- `Shake`: filha de Sobremesa. Escolhe o preço pelo sabor e soma as frutas.
- `Main`: o menu, a leitura do teclado e o controle do pedido e do caixa.

## Conceitos de POO usados

- Abstração: `Sobremesa` é abstrata e não pode ser instanciada
- Herança: `Acai` e `Shake` usam `extends Sobremesa` e chamam `super(...)`
- Sobrescrita: `calcularPreco()` e `toString()` nas duas filhas
- Sobrecarga: a `Acai` tem dois construtores (com e sem complementos)
- Encapsulamento: atributos privados com getters, e as classes validam os valores
  que recebem (se vier algo inválido, avisam e usam um valor padrão)

## Como rodar

Pelo IntelliJ: abrir o projeto e rodar a classe `Main`.

Pelo terminal, na pasta do projeto:

```
mvn compile
java -cp target/classes cumbe.app.Main
```

É preciso ter o JDK instalado e o `JAVA_HOME` configurado. Dá pra conferir com
`java -version` e `javac -version`.

## Validações

O `Main` pergunta de novo quando o usuário digita um número fora do permitido
(tamanho diferente de 300/500, complementos fora de 0 a 3, frutas fora de 0 a 2,
sabor ou leite que não existem). Assim o programa não quebra com número negativo
ou muito grande.

## Limitações

- Se digitar letra onde era pra ser número, o programa dá erro (`InputMismatchException`),
  porque ainda não tratei isso.
- Item que foi pedido mas não finalizado (opção 3) não entra no total de vendas.
- Não guarda o nome das frutas e complementos, só a quantidade.
