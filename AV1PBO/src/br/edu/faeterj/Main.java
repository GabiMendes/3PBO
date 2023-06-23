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
            System.out.println("6 - Exibir itens de uma categoria");
            System.out.println("7 - Exibir itens de um fabricante");

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

                        Categoria novaCategoria = new Categoria(id, categoria);
                        Fabricante novoFabricante = new Fabricante(id, fabricante, "");
                        Produto prod = new Produto(id, sku, nome, valor, peso, codBarra, descricao, novaCategoria, novoFabricante, qtd);
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
                        }
                    }

                    if (!produtoEncontrado) {
                        System.out.println("Nenhum produto encontrado com o ID informado.");
                    }
                    break;

                case 4:
                    System.out.println("Alterar 1 produto:  ");
                    System.out.println("Digite a id (chave única) do produto:  ");

                    idBuscar = sc.nextInt();

                    boolean produtoAlterado = false;

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getId() == idBuscar) {
                            System.out.println("Sku do produto:  ");
                            sku = sc.next();
                            prodArmazenado.setSku(sku);

                            System.out.println("Nome do produto:  ");
                            nome = sc.next();
                            prodArmazenado.setNome(nome);

                            System.out.println("Valor do produto:  ");
                            valor = sc.nextInt();
                            prodArmazenado.setValor(valor);

                            System.out.println("Peso do produto:  ");
                            peso = sc.nextInt();
                            prodArmazenado.setPeso(peso);

                            System.out.println("CodBarra do produto:  ");
                            codBarra = sc.nextLong();
                            prodArmazenado.setCodBarra(codBarra);

                            sc.nextLine();

                            System.out.println("Descrição do produto:  ");
                            descricao = sc.nextLine();
                            prodArmazenado.setDescricao(descricao);

                            System.out.println("Categoria do produto:  ");
                            categoria = sc.next();
                            prodArmazenado.getCategoria().setCategoria(categoria);

                            System.out.println("Fabricante do produto:  ");
                            fabricante = sc.next();
                            prodArmazenado.getFabricante().setNome(fabricante);

                            System.out.println("Quantidade do produto:  ");
                            qtd = sc.nextInt();
                            prodArmazenado.setQtd(qtd);

                            produtoAlterado = true;
                            break;
                        }
                    }

                    if (!produtoAlterado) {
                        System.out.println("Nenhum produto encontrado com o ID informado.");
                    } else {
                        System.out.println("Produto alterado com sucesso.");
                    }
                    break;

                case 5:
                    System.out.println("Deletar 1 produto:  ");
                    System.out.println("Digite a id (chave única) do produto:  ");

                    idBuscar = sc.nextInt();

                    boolean produtoRemovido = false;

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getId() == idBuscar) {
                            lProd.remove(prodArmazenado);
                            produtoRemovido = true;
                            break;
                        }
                    }

                    if (!produtoRemovido) {
                        System.out.println("Nenhum produto encontrado com o ID informado.");
                    } else {
                        System.out.println("Produto removido com sucesso.");
                    }
                    break;

                case 6:
                    System.out.println("Exibir itens de uma categoria:  ");
                    System.out.println("Digite o nome da categoria:  ");

                    categoria = sc.next();

                    boolean categoriaEncontrada = false;

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getCategoria().getCategoria().equalsIgnoreCase(categoria)) {
                            System.out.println(prodArmazenado.detProduto());
                            categoriaEncontrada = true;
                        }
                    }

                    if (!categoriaEncontrada) {
                        System.out.println("Nenhum produto encontrado para a categoria informada.");
                    }
                    break;

                case 7:
                    System.out.println("Exibir itens de um fabricante:");
                    System.out.println("Digite o nome do fabricante: ");
                    fabricante = sc.next();

                    boolean fabricanteEncontrado = false;

                    for (Produto prodArmazenado : lProd) {
                        if (prodArmazenado.getFabricante().getNome().equalsIgnoreCase(fabricante)) {
                            System.out.println(prodArmazenado.detProduto());
                            fabricanteEncontrado = true;
                        }
                    }

                    if (!fabricanteEncontrado) {
                        System.out.println("Nenhum produto encontrado para o fabricante informado.");
                    }
                    break;


                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Deseja continuar? S para Sim, N para Não.");
            respostaSwitch = sc.next();
        } while (!respostaSwitch.equalsIgnoreCase("N"));

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}
