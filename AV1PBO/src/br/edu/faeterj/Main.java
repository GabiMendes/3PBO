package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> lProd = new ArrayList<Produto>();
        Scanner sc = new Scanner(System.in);
        String respostaSwitch = "";
        String respostaIncluir = "";

        String sku = "";
        String nome = "";
        int valor = -1;
        int peso = -1;
        String descricao = "";
        int qtd = -1;
        long codBarra = -1;
        String categoria = "";
        String fabricante = "";
        int id = -1;
        int idBuscar = -1;
        int opcao = -1;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Listar um produto");
            System.out.println("4 - Alterar um produto");
            System.out.println("5 - Deletar um produto");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
                    respostaIncluir = sc.next();

                    while (!respostaIncluir.equalsIgnoreCase("N")) {
                        sc.nextLine();

                        System.out.println("Sku do produto:  ");
                        sku = sc.nextLine();

                        System.out.println("Nome do produto:  ");
                        nome = sc.nextLine();

                        System.out.println("Valor do produto:  ");
                        valor = sc.nextInt();

                        System.out.println("Peso do produto:  ");
                        peso = sc.nextInt();

                        System.out.println("CodBarra do produto:  ");
                        codBarra = sc.nextLong();

                        sc.nextLine();

                        System.out.println("Descrição do produto:  ");
                        descricao = sc.nextLine();

                        System.out.println("Categoria do produto:  ");
                        categoria = sc.nextLine();

                        System.out.println("Fabricante do produto:  ");
                        fabricante = sc.nextLine();

                        System.out.println("Quantidade do produto:  ");
                        qtd = sc.nextInt();

                        id = id + 1;

                        Produto prod = new Produto(id, sku, nome, valor, peso, codBarra, descricao, categoria, fabricante, qtd);
                        lProd.add(prod);

                        System.out.println("Quer cadastrar novo produto? S para Sim, N para Não.");
                        respostaIncluir = sc.next();
                    }
                    break;

                case 2:
                    System.out.println("Listar produtos: ");

                    for (Produto prodArmazenado : lProd) {
                        System.out.println(prodArmazenado.detProduto());
                    }
                    break;

                case 3:
                    System.out.println("Listar 1 produto:  ");
                    System.out.println("Digite a id (chave única) do produto:  ");

                    idBuscar = sc.nextInt();

                    boolean produtoEncontrado = false;

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getId() == idBuscar) {
                            System.out.println(prodArmazenado.detProduto());
                            produtoEncontrado = true;
                            break;
                        } else {
                            System.out.println("Nenhum produto encontrado com o ID informado.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alterar 1 produto:  ");
                    System.out.println("Digite a id (chave única) do produto:  ");

                    idBuscar = sc.nextInt();

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getId() == idBuscar) {
                            produtoEncontrado = true;

                            System.out.println("Dados antigos do produto:  ");
                            System.out.println(prodArmazenado.detProduto());

                            System.out.println("Digite as novas informações do produto: ");
                            sc.nextLine();

                            System.out.println("Sku do produto:  ");
                            sku = sc.nextLine();

                            System.out.println("Nome do produto:  ");
                            nome = sc.nextLine();

                            System.out.println("Valor do produto:  ");
                            valor = sc.nextInt();

                            System.out.println("Peso do produto:  ");
                            peso = sc.nextInt();

                            System.out.println("CodBarra do produto:  ");
                            codBarra = sc.nextLong();

                            sc.nextLine();

                            System.out.println("Descrição do produto:  ");
                            descricao = sc.nextLine();

                            System.out.println("Categoria do produto:  ");
                            categoria = sc.nextLine();

                            System.out.println("Fabricante do produto:  ");
                            fabricante = sc.nextLine();

                            System.out.println("Quantidade do produto:  ");
                            qtd = sc.nextInt();

                            prodArmazenado.altProduto(id, sku, nome, valor, peso, codBarra, descricao, categoria, fabricante, qtd);
                            System.out.println("Produto alterado com sucesso!");

                            System.out.println("Dados atualizados do produto:  ");
                            System.out.println(prodArmazenado.detProduto());

                            break;
                        } else {
                            System.out.println("Nenhum produto encontrado com o ID informado.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Deletar 1 produto:  ");
                    System.out.println("Digite a id (chave única) do produto:  ");

                    idBuscar = sc.nextInt();

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getId() == idBuscar) {
                            produtoEncontrado = true;

                            System.out.println("Dados deletados:  ");
                            System.out.println(prodArmazenado.detProduto());

                            prodArmazenado.delProduto(id, sku, nome, valor, peso, codBarra, descricao, categoria, fabricante, qtd);

                            break;
                        } else {
                            System.out.println("Nenhum produto encontrado com o ID informado.");
                        }
                    }
                    break;


                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Quer realizar nova operação? S para Sim, N para Não.");
            respostaSwitch = sc.next();

        } while (!respostaSwitch.equalsIgnoreCase("N"));
        sc.close();
    }
}
