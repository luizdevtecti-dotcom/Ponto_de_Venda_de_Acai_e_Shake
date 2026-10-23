/**
 * Programa principal do Ponto de Venda Cumbe Açaí e Shake.
 * Mostra o menu, monta os pedidos, mostra o valor a pagar
 * e, ao fechar o caixa, o total de vendas.
 */

import java.util.Scanner;

public class Main {

    /**
     * Método principal. Repete o menu até o usuário escolher 0 (fechar caixa).
     */
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Integer opcao = -1;                                                 // guarda a opção escolhida no menu (começa com valor inválido)

        Double totalPedido = 0.0;                                           // soma dos itens do pedido atual
        Double totalVendas = 0.0;                                           // soma de todos os pedidos já finalizados

        // repete o menu até o usuário escolher 0 (fechar caixa)
        do {
            System.out.println("==================================\n" +     // mostra as opções do menu
                    "= PONTO DE VENDA DE AÇAÍ E SHAKE =\n" +
                    "======== 0 - FECHAR CAIXA ========\n" +
                    "======== 1 - PEDIR AÇAÍ ==========\n" +
                    "======== 2 - PEDIR SHAKE =========\n" +
                    "======== 3 - FINALIZAR  PEDIDO ===\n" +
                    "==================================");

            System.out.printf("============= DIGITE UMA OPÇÃO: ");
            opcao = leitura.nextInt();

            if (opcao == 1) {                                               // opção 1: monta um açaí e soma no pedido
                System.out.println("AÇAÍ ESCOLHIDO");

                Integer tamanhoMl;

                do {
                    System.out.println("QUAL TAMANHO DO AÇAÍ (300ML OU 500ML)?");
                    tamanhoMl = leitura.nextInt();
                    if (tamanhoMl != 300 && tamanhoMl != 500) {
                        System.out.println("TAMANHO INVÁLIDO. TENTE NOVAMENTE.");
                    }
                } while (tamanhoMl != 300 && tamanhoMl != 500);

                Integer qtdComplementos;

                do {
                    System.out.println("QUANTOS COMPLEMENTOS DESEJA (0 A 3)?");
                    qtdComplementos = leitura.nextInt();
                    if (qtdComplementos < 0 || qtdComplementos > 3) {
                        System.out.println("QUANTIDADE INVÁLIDA. TENTE NOVAMENTE.");
                    }
                } while (qtdComplementos < 0 || qtdComplementos > 3);

                Acai pedidoAcai1 = new Acai("Açaí", tamanhoMl, qtdComplementos);

                System.out.println(pedidoAcai1);

                totalPedido = totalPedido + pedidoAcai1.calcularPreco();

            } else if (opcao == 2) {                                    // opção 2: monta um shake e soma no pedido
                System.out.println("SHAKE ESCOLHIDO");

                Integer qtdFrutas;
                do {
                    System.out.println("QUANTAS FRUTAS DESEJA (0 A 2)?");
                    qtdFrutas = leitura.nextInt();
                    if (qtdFrutas < 0 || qtdFrutas > 2) {
                        System.out.println("QUANTIDADE INVÁLIDA. TENTE NOVAMENTE.");
                    }
                } while (qtdFrutas < 0 || qtdFrutas > 2);

                Integer opSabor;
                do {
                    System.out.println("1 - OREO\n2 - OvoMaldini\nQUAL SABOR DESEJA?");
                    opSabor = leitura.nextInt();
                    if (opSabor != 1 && opSabor != 2) {
                        System.out.println("SABOR INVÁLIDO. TENTE NOVAMENTE.");
                    }
                } while (opSabor != 1 && opSabor != 2);

                String sabor;
                if (opSabor == 1) {
                    sabor = "Oreo";
                } else {
                    sabor = "OvoMaldini";
                }

                Integer opLeite;
                do {
                    System.out.println("1 - VACA\n2 - COCO\nQUAL TIPO DE LEITE DESEJA?");
                    opLeite = leitura.nextInt();
                    if (opLeite != 1 && opLeite != 2) {
                        System.out.println("LEITE INVÁLIDO. TENTE NOVAMENTE.");
                    }
                } while (opLeite != 1 && opLeite != 2);

                String tipoDeLeite;
                if (opLeite == 1) {
                    tipoDeLeite = "Vaca";
                } else {
                    tipoDeLeite = "Coco";
                }

                Shake pedidoShake1 = new Shake("Shake", qtdFrutas, tipoDeLeite, sabor);

                System.out.println(pedidoShake1);

                totalPedido = totalPedido + pedidoShake1.calcularPreco();

            } else if (opcao == 3) {                                    // opção 3: finaliza o pedido e mostra o valor a pagar
                if (totalPedido == 0.0) {
                    System.out.println("==== NENHUM ITEM NO PEDIDO!!!! ===");
                } else {
                    System.out.println("==================================");
                    System.out.println("= PEDIDO FINALIZADO");
                    System.out.printf("= VALOR A PAGAR: R$ %.2f%n", totalPedido);
                    System.out.println("==================================");
                    totalVendas = totalPedido + totalVendas;
                    totalPedido = 0.0;
                }
            } else if (opcao != 0) {                                    // qualquer outro número diferente de 0 é opção inválida
                System.out.println("OPÇÃO INVÁLIDA");
            }
        } while (opcao != 0);                                           // caixa fechado: mostra o total de vendas de todos os pedidos
        System.out.println("==================================");
        System.out.println("= CAIXA FECHADO");
        System.out.printf("= TOTAL DE VENDAS: R$ %.2f%n ", totalVendas);
        System.out.println("==================================");
    }
}
