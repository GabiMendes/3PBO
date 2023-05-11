package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto prod = new Produto();
        ArrayList<Produto> lproduto = new ArrayList();

        String resposta = "";

        System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
        resposta = sc.next();

        while(!resposta.equalsIgnoreCase("N"))
        {
            Produto produto = new Produto();
            produto.registrarProduto();
            lproduto.add(produto);
            System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
            resposta = sc.next();
        }

        sc.close();

    }

}
