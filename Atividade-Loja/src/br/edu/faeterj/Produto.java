package br.edu.faeterj;
import java.util.Scanner;

public class Produto {

    public String nome;
    public Double valor;
    public int qtd;
    public int codBarra;
    public String descricao;

    public void registrarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto:  ");
        nome = sc.next();
        System.out.println("Digite o valor do produto:  ");
        valor = sc.nextDouble();
        System.out.println("Digite a quantidade do produto:  ");
        qtd = sc.nextInt();
        System.out.println("Digite o código de barras do produto:  ");
        codBarra = sc.nextInt();
        sc.nextLine(); // consumir o restante da linha do código de barras,
        System.out.println("Digite a descrição do produto:  ");
        descricao = sc.nextLine();

        System.out.println("Nome Produto:" + nome);
        System.out.println("Valor Produto:" + valor);
        System.out.println("Quantidade Produto:" + qtd);
        System.out.println("Descrição Produto:" + descricao);
        System.out.println("CodBarra Produto:" + codBarra);

        sc.close();
    }
}