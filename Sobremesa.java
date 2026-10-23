/**
 * Classe abstrata que serve de base para tudo que a loja vende.
 * Guarda o que Açaí e Shake têm em comum: nome, tamanho e preço base.
 * Como é abstrata, não dá para criar uma Sobremesa direto, só as filhas.
 */
public abstract class Sobremesa {
    /**
     * Nome do produto, como aparece no pedido.
     */
    private String nome;
    /**
     * Volume da sobremesa, em ml.
     */
    private Integer tamanhoMl;
    /**
     * Preço inicial, em reais, antes de somar complementos ou frutas.
     */
    private Double precoBase;

    /**
     * Construtor que cria uma sobremesa. Recebe o nome do produto,
     * o preço base em reais e o tamanho em ml.
     */
    public Sobremesa(String nome, Double precoBase, Integer tamanhoMl) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.tamanhoMl = tamanhoMl;
    }
    /**
     * Devolve o nome do produto.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Devolve o preço base, em reais.
     */
    public Double getPrecoBase() {
        return precoBase;
    }
    /**
     * Devolve o tamanho, em ml.
     */
    public Integer getTamanhoMl() {
        return tamanhoMl;
    }
    /**
     * Troca o nome do produto pelo nome recebido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Calcula o preço final da sobremesa. Cada filha faz o seu cálculo,
     * por isso o método é abstrato. Devolve o valor em reais.
     */
    public abstract Double calcularPreco();
}
