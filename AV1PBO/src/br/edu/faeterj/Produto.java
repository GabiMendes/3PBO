package br.edu.faeterj;

public class Produto {
    private int id;
    private String sku;
    private String nome;
    private int valor;
    private int peso;
    private long codBarra;
    private String descricao;
    private Categoria categoria;
    private Fabricante fabricante;
    private int qtd;

    public Produto(int id, String sku, String nome, int valor, int peso, long codBarra, String descricao, Categoria categoria, Fabricante fabricante, int qtd) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
        this.codBarra = codBarra;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public long getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(long codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String detProduto() {
        String result = "ID: " + id +
                ", SKU: " + sku +
                ", Nome: " + nome +
                ", Valor: " + valor +
                ", Peso: " + peso +
                ", Código de Barras: " + codBarra +
                ", Descrição: " + descricao +
                ", Categoria: " + categoria.getCategoria();

        if (fabricante != null) {
            result += ", Fabricante: " + fabricante.getNome();
        } else {
            result += ", Fabricante: N/A";
        }

        result += ", Quantidade: " + qtd;

        return result;
    }
}
