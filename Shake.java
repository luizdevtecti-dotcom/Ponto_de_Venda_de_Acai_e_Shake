/**
 * Shake de 500ml, com leite de vaca ou de coco e até 2 frutas.
 * Herda de Sobremesa. O sabor define o preço base e cada fruta
 * soma um valor no final. O tipo de leite não muda o preço.
 */
public class Shake extends Sobremesa {

    /**
     * Tipo de leite do shake (vaca ou coco).
     */
    private String tipoLeite;

    /**
     * Quantidade de frutas do shake (de 0 a 2).
     */
    private Integer qtdFrutas;

    /**
     * Sabor do shake (Oreo ou OvoMaldini).
     */
    private String sabor;

    /**
     * Valor de cada fruta, em reais.
     */
    private static final Double PRECO_FRUTA = 3.79;

    /**
     * Preço base do shake de Oreo, em reais.
     */
    private static final Double PRECO_SABOR_OREO = 6.00;

    /**
     * Preço base do shake de OvoMaldini, em reais.
     */
    private static final Double PRECO_SABOR_OVOMALDINI = 6.00;

    /**
     * Escolhe o preço base de acordo com o sabor recebido.
     * É static porque é chamado dentro do super(), antes do objeto existir.
     * Se o sabor for inválido, avisa e devolve o preço do Oreo.
     */
    private static Double obterPrecoPorSabor(String sabor) {
        if (sabor.equals("Oreo")) {
            return PRECO_SABOR_OREO;
        } else if (sabor.equals("OvoMaldini")) {
            return PRECO_SABOR_OVOMALDINI;
        } else {
            System.out.println("ERRO!!!!!! SABOR INVALIDO. USANDO Oreo!!!!!!!!!\n");
            return PRECO_SABOR_OREO;
        }
    }

    /**
     * Construtor que cria um shake de 500ml com nome, quantidade de
     * frutas (0 a 2), tipo de leite e sabor. Se a quantidade de frutas
     * for inválida, avisa e usa 0 frutas.
     */
    public Shake(String nome, Integer qtdFrutas, String tipoLeite, String sabor) {
        super(nome, obterPrecoPorSabor(sabor), 500);
        if (qtdFrutas < 0 || qtdFrutas > 2) {
            System.out.printf("ERRO!!!!! QUANTIDADE INVALIDA. USANDO 0 FRUTAS !!!!!\n");
            this.qtdFrutas = 0;
        } else {
            this.qtdFrutas = qtdFrutas;
        }
        this.tipoLeite = tipoLeite;
        this.sabor = sabor;
    }

    /**
     * Calcula o preço final do shake: preço base do sabor mais o valor
     * das frutas. Devolve o valor em reais.
     */
    @Override
    public Double calcularPreco() {
        return getPrecoBase().doubleValue() + (qtdFrutas * PRECO_FRUTA);
    }

    /**
     * Monta o texto com os dados do shake (nome, sabor, leite, frutas
     * e preço) para mostrar no pedido.
     */
    @Override
    public String toString() {
        return getNome() + "  |  " + "SABOR DO SHAKE: " + sabor + "  |  " +
                "TIPO DE LEITE: " + tipoLeite + "  |  " + "QUANTIDADE FRUTA(S): " + qtdFrutas + "  |  " + "R$ " +
                String.format("%.2f", calcularPreco());
    }
}
