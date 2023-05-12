package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> lProd = new ArrayList<Produto>();
        Scanner sc = new Scanner(System.in);
        String resposta = "";

        System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
        resposta = sc.next();

        String nome = "";
        int valor = -1;
        String descricao = "";
        int qtd = -1;
        long codBarra = -1;
        int id = -1;

        while(!resposta.equalsIgnoreCase("N"))
        {
            System.out.println("Nome do produto:  ");
            nome = sc.next();

            System.out.println("Valor do produto:  ");
            valor = sc.nextInt();

            System.out.println("CodBarra do produto:  ");
            codBarra = sc.nextLong();

            System.out.println("Descrição do produto:  ");
            descricao = sc.next();

            System.out.println("Quantidade do produto:  ");
            qtd = sc.nextInt();

            id = id+1;

            Produto prod = new Produto(id, nome, valor, codBarra, descricao, qtd);
            lProd.add(prod);

            System.out.println(prod.detProduto());

            System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
            resposta = sc.next();

        }
        sc.close();
    }
}