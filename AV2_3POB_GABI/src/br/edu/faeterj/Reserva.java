package br.edu.faeterj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reserva {

    private int id;
    private Quarto quarto;
    private List<Cama> camas;
    private Cliente cliente;
    private String dataEntrada;
    private String dataSaida;

    public Reserva(Quarto quarto, Cliente cliente, String dataEntrada, String dataSaida) {
        this.id = nextId++;
        this.quarto = quarto;
        this.camas = new ArrayList<>();
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;

        cliente.addReserva(this);
    }

    public int getId() {
        return id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Cama> getCamas() {
        return camas;
    }

    public void addCama(Cama cama) {
        camas.add(cama);
    }

    public void removeCama(Cama cama) {
        camas.remove(cama);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteEncontrado) {
        this.cliente = cliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void IncluirReserva() {
        try {
            FileWriter fileWriter = new FileWriter("reserva.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + id);
            printWriter.println("ID do Quarto: " + quarto.getId());
            printWriter.print("ID das Camas: ");
            for (Cama cama : camas) {
                printWriter.print(cama.getId() + " ");
            }
            printWriter.println();
            printWriter.println("ID do Cliente: " + cliente.getId());
            printWriter.println("Necessita de Banheiro? " + quarto.isTemBanheiro());
            printWriter.println("Quantas camas? " + quarto.getQtdeCamas());
            printWriter.println("Data de Entrada: " + dataEntrada);
            printWriter.println("Data de Saída: " + dataSaida);
            printWriter.println();

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar reserva em arquivo: " + e.getMessage());
        }
    }

    public static void listarReservas() {
        try {
            File file = new File("reserva.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static Reserva listarReserva(int cpfBuscar) {
        try {
            File file = new File("reserva.txt");
            Scanner scanner = new Scanner(file);
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("ID do Cliente: " + cpfBuscar)) {
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
                System.out.println("Reserva não encontrada para o CPF informado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
        return null;
    }

    public static void alterarReserva(int cpfAlterar, Reserva reserva) {
        Reserva reservaEncontrada = listarReserva(cpfAlterar);
        if (reservaEncontrada != null) {
            Cliente clienteEncontrado = reservaEncontrada.getCliente();
            reserva.setCliente(clienteEncontrado);
            try {
                File file = new File("reserva.txt");
                File tempFile = new File("temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("ID do Cliente: " + cpfAlterar)) {
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
                        System.out.println("1 - Data de Entrada");
                        System.out.println("2 - Data de Saída");
                        System.out.println("3 - ID do Quarto");
                        System.out.println("4 - ID da Cama");
                        System.out.println("5 - Precisa de banheiro");
                        System.out.println("6 - Precisa de beliche");

                        Scanner sc = new Scanner(System.in);
                        int campo = sc.nextInt();
                        sc.nextLine();

                        switch (campo) {
                            case 1:
                                System.out.println("Digite a nova data de entrada: ");
                                String novaDataEntrada = sc.nextLine();
                                reserva.setDataEntrada(novaDataEntrada);
                                line = line.replace("Data de Entrada: " + reserva.getDataEntrada(), "Data de Entrada: " + novaDataEntrada);
                                break;

                            case 2:
                                System.out.println("Digite a nova data de saída: ");
                                String novaDataSaida = sc.nextLine();
                                reserva.setDataSaida(novaDataSaida);
                                line = line.replace("Data de Saída: " + reserva.getDataSaida(), "Data de Saída: " + novaDataSaida);
                                break;

                            case 3:
                                System.out.println("Digite o novo ID do quarto: ");
                                int novoIdQuarto = sc.nextInt();
                                reserva.getQuarto().setId(novoIdQuarto);
                                line = line.replace("ID do Quarto: " + reserva.getQuarto().getId(), "ID do Quarto: " + novoIdQuarto);
                                break;

                            case 4:
                                System.out.println("Digite o novo ID da cama: ");
                                int novoIdCama = sc.nextInt();
                                for (Cama cama : reserva.getCamas()) {
                                    cama.setId(novoIdCama);
                                }
                                line = line.replace("ID das Camas: " + getCamasIds(reserva.getCamas()), "ID das Camas: " + novoIdCama);
                                break;

                            case 5:
                                System.out.println("Precisa de banheiro? (S/N): ");
                                String respostaBanheiro = sc.nextLine();
                                boolean temBanheiro = respostaBanheiro.equalsIgnoreCase("S") || respostaBanheiro.equalsIgnoreCase("Sim");
                                reserva.getQuarto().setTemBanheiro(temBanheiro);
                                line = line.replace("Necessita de Banheiro? " + reserva.getQuarto().isTemBanheiro(), "Necessita de Banheiro? " + temBanheiro);
                                break;

                            case 6:
                                System.out.println("Precisa de beliche? (S/N): ");
                                String respostaBeliche = sc.nextLine();
                                boolean ehBeliche = respostaBeliche.equalsIgnoreCase("S") || respostaBeliche.equalsIgnoreCase("Sim");
                                reserva.getQuarto().setQtdeCamas(ehBeliche ? reserva.getQuarto().getQtdeCamas() / 2 : reserva.getQuarto().getQtdeCamas());
                                line = line.replace("Quantas camas? " + reserva.getQuarto().getQtdeCamas(), "Quantas camas? " + (ehBeliche ? reserva.getQuarto().getQtdeCamas() / 2 : reserva.getQuarto().getQtdeCamas()));
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
                    System.out.println("Reserva não encontrada para o CPF informado.");
                } else {
                    file.delete();
                    tempFile.renameTo(file);
                    System.out.println("Reserva alterada com sucesso.");
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

    private static String getCamasIds(List<Cama> camas) {
        StringBuilder builder = new StringBuilder();
        for (Cama cama : camas) {
            builder.append(cama.getId()).append(" ");
        }
        return builder.toString().trim();
    }

    public static void excluirReserva(int cpfExcluir) {
        try {
            File file = new File("reserva.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("ID do Cliente: " + cpfExcluir)) {
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
                System.out.println("Reserva excluída com sucesso.");
            } else {
                System.out.println("Reserva não encontrada para o CPF informado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }

    private static int nextId = 1;
    private static int getNextId() {
        return nextId++;
    }
}
