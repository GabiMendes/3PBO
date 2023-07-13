package br.edu.faeterj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String postalCode;
    private String pais;
    private int cpf;
    private int passaporte;
    private String email;
    private String dataNascimento;
    private ArrayList<Reserva> reservas;

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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public int getPassaporte() {
        return passaporte;
    }
    public void setPassaporte(int passaporte) {
        this.passaporte = passaporte;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente(int id, String nome, String endereco, String postalCode, String pais, int cpf, int passaporte, String email, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCode = postalCode;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.reservas = new ArrayList<Reserva>();
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void IncluirCliente() {
        try {
            FileWriter fileWriter = new FileWriter("cliente.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + id);
            printWriter.println("Nome: " + nome);
            printWriter.println("Endereço: " + endereco);
            printWriter.println("Código Postal: " + postalCode);
            printWriter.println("País: " + pais);
            printWriter.println("CPF: " + cpf);
            printWriter.println("Passaporte: " + passaporte);
            printWriter.println("Email: " + email);
            printWriter.println("Data de Nascimento: " + dataNascimento);
            printWriter.println();

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente em arquivo: " + e.getMessage());
        }
    }

    //Os métodos abaixo não foram utilizados na MAIN, mas servem às propostas da prova.

    public static void listarCliente(int cpfBuscar) {
        try {
            File file = new File("cliente.txt");
            Scanner scanner = new Scanner(file);
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("CPF: " + cpfBuscar)) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(line).append("\n");
                    while (scanner.hasNextLine()) {
                        String nextLine = scanner.nextLine();
                        if (nextLine.isEmpty()) {
                            break;
                        }
                        builder.append(nextLine).append("\n");
                    }
                    System.out.println(builder.toString());
                    found = true;
                    break;
                }
            }
            scanner.close();

            if (!found) {
                System.out.println("Cliente não encontrado para o CPF informado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static void alterarCliente(int cpfAlterar, Cliente cliente) {
        listarCliente(cpfAlterar);
        if (cliente != null) {
            try {
                File file = new File("cliente.txt");
                File tempFile = new File("tempCliente.txt");

                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("CPF: " + cpfAlterar)) {
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
                        System.out.println("1 - Nome");
                        System.out.println("2 - Endereço");
                        System.out.println("3 - Código Postal");
                        System.out.println("4 - País");
                        System.out.println("5 - Passaporte");
                        System.out.println("6 - Email");
                        System.out.println("7 - Data de Nascimento");

                        Scanner sc = new Scanner(System.in);
                        int campo = sc.nextInt();
                        sc.nextLine();

                        switch (campo) {
                            case 1:
                                System.out.println("Digite o novo nome: ");
                                String novoNome = sc.nextLine();
                                cliente.setNome(novoNome);
                                line = line.replace("Nome: " + cliente.getNome(), "Nome: " + novoNome);
                                break;

                            case 2:
                                System.out.println("Digite o novo endereço: ");
                                String novoEndereco = sc.nextLine();
                                cliente.setEndereco(novoEndereco);
                                line = line.replace("Endereço: " + cliente.getEndereco(), "Endereço: " + novoEndereco);
                                break;

                            case 3:
                                System.out.println("Digite o novo código postal: ");
                                String novoPostalCode = sc.nextLine();
                                cliente.setPostalCode(novoPostalCode);
                                line = line.replace("Código Postal: " + cliente.getPostalCode(), "Código Postal: " + novoPostalCode);
                                break;

                            case 4:
                                System.out.println("Digite o novo país: ");
                                String novoPais = sc.nextLine();
                                cliente.setPais(novoPais);
                                line = line.replace("País: " + cliente.getPais(), "País: " + novoPais);
                                break;

                            case 5:
                                System.out.println("Digite o novo passaporte: ");
                                int novoPassaporte = sc.nextInt();
                                cliente.setPassaporte(novoPassaporte);
                                line = line.replace("Passaporte: " + cliente.getPassaporte(), "Passaporte: " + novoPassaporte);
                                break;

                            case 6:
                                System.out.println("Digite o novo email: ");
                                String novoEmail = sc.nextLine();
                                cliente.setEmail(novoEmail);
                                line = line.replace("Email: " + cliente.getEmail(), "Email: " + novoEmail);
                                break;

                            case 7:
                                System.out.println("Digite a nova data de nascimento: ");
                                String novaDataNascimento = sc.nextLine();
                                cliente.setDataNascimento(novaDataNascimento);
                                line = line.replace("Data de Nascimento: " + cliente.getDataNascimento(), "Data de Nascimento: " + novaDataNascimento);
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
                    System.out.println("Cliente não encontrado para o CPF informado.");
                } else {
                    file.delete();
                    tempFile.renameTo(file);
                    System.out.println("Cliente alterado com sucesso.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro ao ler/escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Cliente não encontrado para o CPF informado.");
        }
    }


    public void ExcluirCliente(int cpfExcluir) {
        try {
            File file = new File("cliente.txt");
            File tempFile = new File("tempCliente.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("CPF: " + cpfExcluir)) {
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
                System.out.println("Cliente excluído com sucesso.");
            } else {
                System.out.println("Cliente não encontrado para o CPF informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }


    private static int nextId = 1;
    static int getNextId() {
        return nextId++;
    }
}

