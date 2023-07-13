package br.edu.faeterj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quarto {

    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public void setQtdeCamas(int qtdeCamas) {
        this.qtdeCamas = qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto(int id, String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = id;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    public void IncluirQuarto() {
        try {
            FileWriter fileWriter = new FileWriter("quarto.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + id);
            printWriter.println("Nome do Quarto: " + nomeQuarto);
            printWriter.println("Quantidade de Camas: " + qtdeCamas);
            printWriter.println("Tem Banheiro? " + temBanheiro);
            printWriter.println();

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar quarto em arquivo: " + e.getMessage());
        }
    }
    private static int nextId = 1;
    static int getNextId() {
        return nextId++;
    }

    //Os métodos abaixo não foram utilizados na MAIN, mas servem às propostas da prova.

    public static void listarQuarto(int idQuarto) {
        try {
            File file = new File("quarto.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idQuarto)) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(line).append("\n");
                    while ((line = reader.readLine()) != null) {
                        if (line.isEmpty()) {
                            break;
                        }
                        builder.append(line).append("\n");
                    }
                    System.out.println(builder.toString());
                    found = true;
                    break;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Quarto não encontrado para o ID informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void alterarQuarto(int idQuartoAlterar, Quarto quarto) {
        listarQuarto(idQuartoAlterar);
        if (quarto != null) {
            try {
                File file = new File("quarto.txt");
                File tempFile = new File("tempQuarto.txt");

                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("ID: " + idQuartoAlterar)) {
                        writer.write(line + "\n");

                        StringBuilder builder = new StringBuilder();
                        builder.append(line).append("\n");
                        while ((line = reader.readLine()) != null) {
                            if (line.isEmpty()) {
                                break;
                            }
                            builder.append(line).append("\n");
                        }

                        System.out.println(builder.toString());

                        System.out.println("Qual campo deseja alterar?");
                        System.out.println("1 - Nome do Quarto");
                        System.out.println("2 - Quantidade de Camas");
                        System.out.println("3 - Tem Banheiro");
                        System.out.println("4 - Descrição");

                        Scanner sc = new Scanner(System.in);
                        int campo = sc.nextInt();
                        sc.nextLine();

                        switch (campo) {
                            case 1:
                                System.out.println("Digite o novo nome do quarto: ");
                                String novoNomeQuarto = sc.nextLine();
                                quarto.setNomeQuarto(novoNomeQuarto);
                                line = line.replace("Nome do Quarto: " + quarto.getNomeQuarto(), "Nome do Quarto: " + novoNomeQuarto);
                                break;

                            case 2:
                                System.out.println("Digite a nova quantidade de camas: ");
                                int novaQtdeCamas = sc.nextInt();
                                quarto.setQtdeCamas(novaQtdeCamas);
                                line = line.replace("Quantidade de Camas: " + quarto.getQtdeCamas(), "Quantidade de Camas: " + novaQtdeCamas);
                                break;

                            case 3:
                                System.out.println("O quarto tem banheiro? (true/false): ");
                                boolean temBanheiro = sc.nextBoolean();
                                quarto.setTemBanheiro(temBanheiro);
                                line = line.replace("Tem Banheiro? " + quarto.isTemBanheiro(), "Tem Banheiro? " + temBanheiro);
                                break;

                            case 4:
                                System.out.println("Digite a nova descrição: ");
                                String novaDescricao = sc.nextLine();
                                quarto.setDescricao(novaDescricao);
                                line = line.replace("Descrição: " + quarto.getDescricao(), "Descrição: " + novaDescricao);
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        writer.write(line + "\n");
                        found = true;
                    } else {
                        writer.write(line + "\n");
                    }
                }

                reader.close();
                writer.close();

                if (!found) {
                    System.out.println("Quarto não encontrado para o ID informado.");
                } else {
                    file.delete();
                    tempFile.renameTo(file);
                    System.out.println("Quarto alterado com sucesso.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro ao ler/escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Quarto não encontrado para o ID informado.");
        }
    }

    public void ExcluirQuarto(int idQuartoExcluir) {
        try {
            File file = new File("quarto.txt");
            File tempFile = new File("tempQuarto.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idQuartoExcluir)) {
                    found = true;
                    while ((line = reader.readLine()) != null && !line.isEmpty()) {
                    }
                } else {
                    writer.write(line + "\n");
                }
            }

            writer.close();
            reader.close();

            if (found) {
                if (file.delete()) {
                    if (!tempFile.renameTo(file)) {
                        System.out.println("Erro ao renomear arquivo temporário.");
                    }
                } else {
                    System.out.println("Erro ao excluir arquivo original.");
                }
                System.out.println("Quarto excluído com sucesso.");
            } else {
                System.out.println("Quarto não encontrado para o ID informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir quarto: " + e.getMessage());
        }
    }

}

