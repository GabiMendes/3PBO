package br.edu.faeterj;


import java.util.ArrayList;

public class Produto {
    private int id;
    private String sku;
    private String nome;
    private double valor;
    private double peso;
    private long codBarra;
    private String descricao;
    private String categoria;
    private String fabricante;
    private int qtd;

    //pra alterar é Getters e Setters. Pra selecionar getall?


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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFabricante() {
        return categoria;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String detProduto()
    {
        return "Id: " + id + " Sku: " + sku + " Nome: " + nome + " Código de Barras: " + codBarra + " Valor: " + valor + " Peso: " + peso + " Descricao: " + descricao + " Quantidade: " + qtd + " Categoria: " + categoria + " Fabricante: " + fabricante;
    }

    public void altProduto (int id, String sku, String nome, int valor, int peso, long codBarra, String descricao, String categoria, String fabricante, int qtd)
    {
        this.setId(id);
        this.setSku(sku);
        this.setNome(nome);
        this.setValor(valor);
        this.setPeso(peso);
        this.setCodBarra(codBarra);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setFabricante(fabricante);
        this.setQtd(qtd);
    }

    public void delProduto(ArrayList<Produto> listaProdutos) {
        listaProdutos.remove(this);
    }


    public Produto(int id, String sku, String nome, int valor, int peso, long codBarra, String descricao, String categoria, String fabricante, int qtd) {
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
}