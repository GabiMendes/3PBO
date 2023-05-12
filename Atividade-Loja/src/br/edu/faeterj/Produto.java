package br.edu.faeterj;


public class Produto {
    private int id;
    private String nome;
    private double valor;
    private long codBarra;
//    private int idCategoria;
    private String descricao;
    private int qtd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String detProduto()
    {
        return "Nome produto: " + nome + " Código de Barras: " + codBarra + " Valor: " + valor + " Descricao: " + descricao + " Quantidade: " + qtd;
    }

    public Produto(int id, String nome, int valor, long codBarra, String descricao, int qtd) {
        this.nome = nome;
        this.valor = valor;
        this.codBarra = codBarra;
        this.descricao = descricao;
        this.qtd = qtd;
    }
}
