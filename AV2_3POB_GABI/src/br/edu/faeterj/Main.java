package br.edu.faeterj;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respostaSwitch = "";
        String respostaIncluir = "";
        int opcao = -1;

        int idCliente = 0;
        int idQuarto = 0;
        int idCama = 0;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir reserva");
            System.out.println("2 - Listar todas as reservas");
            System.out.println("3 - Listar uma reserva");
            System.out.println("4 - Alterar uma reserva");
            System.out.println("5 - Deletar uma reserva");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Quer cadastrar nova Reserva? S para Sim, N para Não.");
                    respostaIncluir = sc.next();

                    while (!respostaIncluir.equalsIgnoreCase("N")) {
                        sc.nextLine();

                        System.out.println("Data de Entrada: ");
                        String dataEntrada = sc.nextLine();

                        System.out.println("Data de Saída: ");
                        String dataSaida = sc.nextLine();

                        System.out.println("Por favor, insira seus dados pessoais. Nome: ");
                        String nome = sc.nextLine();

                        System.out.println("Endereço: ");
                        String endereco = sc.nextLine();

                        System.out.println("Código Postal: ");
                        String postalCode = sc.nextLine();

                        System.out.println("País: ");
                        String pais = sc.nextLine();

                        System.out.println("CPF: ");
                        int cpf = sc.nextInt();

                        System.out.println("Passaporte: ");
                        int passaporte = sc.nextInt();

                        System.out.println("Email: ");
                        sc.nextLine();
                        String email = sc.nextLine();

                        System.out.println("Data de Nascimento: ");
                        String dataNascimento = sc.nextLine();

                        idCliente = Cliente.getNextId();

                        System.out.println("Dados do cliente computados. Agora vamos escolher o quarto. Precisa de banheiro?");
                        String respostaBanheiro = sc.next();
                        boolean temBanheiro = respostaBanheiro.equalsIgnoreCase("S") || respostaBanheiro.equalsIgnoreCase("Sim");

                        System.out.println("Precisa de beliche?");
                        String respostaBeliche = sc.next();
                        boolean ehBeliche = respostaBeliche.equalsIgnoreCase("S") || respostaBeliche.equalsIgnoreCase("Sim");

                        System.out.println("Quantidade de camas necessárias?");
                        int qtdeCamas = sc.nextInt();

                        idQuarto = Quarto.getNextId();
                        idCama = Cama.getNextId();

                        String nomeQuarto = "Quarto " + idQuarto;
                        String codigoCama = "Cama " + idCama;

                        Cliente novoCliente = new Cliente(idCliente, nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
                        Quarto novoQuarto = new Quarto(idQuarto, nomeQuarto, qtdeCamas, temBanheiro, "");
                        Reserva novaReserva = new Reserva(novoQuarto, novoCliente, dataEntrada, dataSaida);

                        for (int i = 0; i < qtdeCamas; i++) {
                            idCama = Cama.getNextId();
                            Cama novaCama = new Cama(idCama, codigoCama + "-" + (i + 1), ehBeliche, "", "");
                            novaReserva.addCama(novaCama);
                        }

                        novaReserva.IncluirReserva();
                        novoCliente.IncluirCliente();
                        novoQuarto.IncluirQuarto();

                        System.out.println("Quer cadastrar nova Reserva? S para Sim, N para Não.");
                        respostaIncluir = sc.next();
                    }
                    break;

                case 2:
                    System.out.println("Listar reservas: ");
                    Reserva.listarReservas();
                    break;

                case 3:
                    System.out.println("Listar 1 reserva: ");
                    System.out.println("Digite o CPF: ");
                    int cpfBuscar = sc.nextInt();
                    Reserva.listarReserva(cpfBuscar);
                    break;

                case 4:
                    System.out.println("Alterar uma reserva");
                    System.out.println("Digite o CPF do cliente: ");
                    int cpfAlterar = sc.nextInt();
                    Reserva reservaEncontrada = Reserva.listarReserva(cpfAlterar);
                    if (reservaEncontrada != null) {
                        Reserva.alterarReserva(cpfAlterar, reservaEncontrada);
                    } else {
                        System.out.println("Reserva não encontrada para o CPF informado.");
                    }
                    break;

                case 5:
                    System.out.println("Excluir uma reserva");
                    System.out.println("Digite o CPF do cliente: ");
                    int cpfExcluir = sc.nextInt();
                    Reserva.excluirReserva(cpfExcluir);
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
