package cumbe.modelo;

/**
 * Açaí vendido em 300ml ou 500ml, com até 3 complementos.
 * Herda de Sobremesa. O tamanho define o preço base e cada
 * complemento soma um valor no final.
 */
public class Acai extends Sobremesa {

    /**
     * Quantidade de complementos do açaí (de 0 a 3).
     */
    private Integer qtdComplementos;

    /**
     * Preço do açaí de 300ml, em reais.
     */
    private static final Double PRECO_300ML = 5.20;

    /**
     * Preço do açaí de 500ml, em reais.
     */
    private static final Double PRECO_500ML = 7.50;

    /**
     * Valor de cada complemento, em reais.
     */
    private static final Double PRECO_COMPLEMENTO = 2.50;

    /**
     * Escolhe o preço base de acordo com o tamanho recebido (300 ou 500).
     * É static porque é chamado dentro do super(), antes do objeto existir.
     * Se o tamanho for inválido, avisa e devolve o preço de 300ml.
     */
    private static Double obterPrecoPorTamanho(Integer tamanhoMl) {
        if (tamanhoMl.equals(300)) {
            return PRECO_300ML;
        } else if (tamanhoMl.equals(500)) {
            return PRECO_500ML;
        } else {
            System.out.println("ERRO!!!!!!! TAMANHO INVÁLIDO, USANDO 300ML!!!!!\n");
            return PRECO_300ML;
        }
    }

    /**
     * Construtor que cria um açaí com nome, tamanho (300 ou 500) e
     * quantidade de complementos (0 a 3). Se a quantidade for inválida,
     * avisa e usa 0 complementos.
     */
    public Acai(String nome, Integer tamanhoMl, Integer qtdComplementos) {
        super(nome, obterPrecoPorTamanho(tamanhoMl), tamanhoMl);
        if (qtdComplementos < 0 || qtdComplementos > 3) {
            System.out.printf("ERRO!!!!! QUANTIDADE INVALIDA. USANDO 0 COMPLEMENTOS!!!!!\n");
            this.qtdComplementos = 0;
        } else {
            this.qtdComplementos = qtdComplementos;
        }
    }

    /**
     * Construtor sobrecarregado: cria um açaí só com nome e tamanho,
     * sem complementos (chama o construtor completo com 0).
     */
    public Acai(String nome, Integer tamanhoMl) {
        this(nome, tamanhoMl, 0);
    }

    /**
     * Calcula o preço final do açaí: preço base do tamanho mais o valor
     * dos complementos. Devolve o valor em reais.
     */
    @Override
    public Double calcularPreco() {
        return getPrecoBase().doubleValue() + (qtdComplementos * PRECO_COMPLEMENTO);
    }

    /**
     * Monta o texto com os dados do açaí (nome, tamanho, complementos
     * e preço) para mostrar no pedido.
     */
    @Override
    public String toString() {
        return getNome() + "  |  " + getTamanhoMl() + "ml  |  " +
                "QUANTIDADE COMPLEMENTO(S): " + qtdComplementos + "  |  " + "R$ " +
                String.format("%.2f", calcularPreco());
    }
}
