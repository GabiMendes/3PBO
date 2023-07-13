package br.edu.faeterj;
import java.io.*;
public class Cama {

    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public void setCodigoCama(String codigoCama) {
        this.codigoCama = codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public void setEhBeliche(boolean ehBeliche) {
        this.ehBeliche = ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cama(int id, String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.id = id;
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }

    //Os métodos abaixo não foram utilizados na MAIN, mas servem às propostas da prova.
    public static void IncluirCama(Cama cama) {
        try {
            FileWriter fileWriter = new FileWriter("cama.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + cama.getId());
            printWriter.println("Código da Cama: " + cama.getCodigoCama());
            printWriter.println("É Beliche: " + cama.isEhBeliche());
            printWriter.println("Posição: " + cama.getPosicao());
            printWriter.println("Descrição: " + cama.getDescricao());
            printWriter.println();

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar cama em arquivo: " + e.getMessage());
        }
    }

    public static void listarCama(String codigoCamaBuscar) {
        try {
            File file = new File("cama.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Código da Cama: " + codigoCamaBuscar)) {
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
                System.out.println("Cama não encontrada para o código informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void alterarCama(String codigoCamaAlterar, Cama cama) {
        listarCama(codigoCamaAlterar);
        if (cama != null) {
            try {
                File file = new File("cama.txt");
                File tempFile = new File("tempCama.txt");

                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("Código da Cama: " + codigoCamaAlterar)) {
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
                        System.out.println("1 - Código da Cama");
                        System.out.println("2 - É Beliche?");
                        System.out.println("3 - Posição");
                        System.out.println("4 - Descrição");

                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        int campo = Integer.parseInt(br.readLine());

                        switch (campo) {
                            case 1:
                                System.out.println("Digite o novo código da cama: ");
                                String novoCodigoCama = br.readLine();
                                cama.setCodigoCama(novoCodigoCama);
                                line = line.replace("Código da Cama: " + cama.getCodigoCama(), "Código da Cama: " + novoCodigoCama);
                                break;

                            case 2:
                                System.out.println("A cama é beliche? (true/false)");
                                boolean novaEhBeliche = Boolean.parseBoolean(br.readLine());
                                cama.setEhBeliche(novaEhBeliche);
                                line = line.replace("É Beliche: " + cama.isEhBeliche(), "É Beliche: " + novaEhBeliche);
                                break;

                            case 3:
                                System.out.println("Digite a nova posição: ");
                                String novaPosicao = br.readLine();
                                cama.setPosicao(novaPosicao);
                                line = line.replace("Posição: " + cama.getPosicao(), "Posição: " + novaPosicao);
                                break;

                            case 4:
                                System.out.println("Digite a nova descrição: ");
                                String novaDescricao = br.readLine();
                                cama.setDescricao(novaDescricao);
                                line = line.replace("Descrição: " + cama.getDescricao(), "Descrição: " + novaDescricao);
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
                    System.out.println("Cama não encontrada para o código informado.");
                } else {
                    file.delete();
                    tempFile.renameTo(file);
                    System.out.println("Cama alterada com sucesso.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro ao ler/escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Cama não encontrada para o código informado.");
        }
    }

    public void ExcluirCama(String codigoCamaExcluir) {
        try {
            File file = new File("cama.txt");
            File tempFile = new File("tempCama.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Código da Cama: " + codigoCamaExcluir)) {
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
                System.out.println("Cama excluída com sucesso.");
            } else {
                System.out.println("Cama não encontrada para o código informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir cama: " + e.getMessage());
        }
    }

    private static int nextId = 1;
    static int getNextId() {
        return nextId++;
    }
}
