package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        ArrayList<Reserva> lReserva = new ArrayList<Reserva>();
        ArrayList<Cliente> lCliente = new ArrayList<Cliente>();
        ArrayList<Quarto> lQuarto = new ArrayList<Quarto>();
        ArrayList<Cama> lCama = new ArrayList<Cama>();

        Scanner sc = new Scanner(System.in);
        String respostaSwitch = "";
        String respostaIncluir = "";
        int opcao = -1;

        int idReserva=0;
        String dataEntrada="";
        String dataSaida="";
        String nome="";
        String endereco="";
        String postalCode="";
        String pais="";
        int cpf=-1;
        int passaporte=-1;
        String email="";
        String dataNascimento="";
        int idCliente=0;
        int idQuarto=-1;
        int qtdeCamas=-1;
        boolean temBanheiro=false;
        String descricaoQuarto="";
        String nomeQuarto="";
        int idCama = -1;
        String codigoCama = "";
        boolean ehBeliche=false;
        String posicaoCama="";
        String descricaoCama="";
        int idBuscar=-1;
        boolean reservaEncontrada=false;

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

                        System.out.println("Data de Entrada:  ");
                        dataEntrada = sc.nextLine();

                        System.out.println("Data de Saída:  ");
                        dataSaida = sc.nextLine();

                        System.out.println("Por favor, insira seus dados pessoais. Nome:  ");
                        nome = sc.nextLine();

                        System.out.println("Endereço:  ");
                        endereco = sc.nextLine();

                        System.out.println("Código Postal:  ");
                        postalCode = sc.nextLine();

                        System.out.println("País:  ");
                        pais = sc.nextLine();

                        System.out.println("CPF:  ");
                        cpf = sc.nextInt();

                        System.out.println("Passaporte:  ");
                        passaporte = sc.nextInt();

                        System.out.println("Email:  ");
                        sc.nextLine();
                        email = sc.nextLine();

                        System.out.println("Data de Nascimento:  ");
                        dataNascimento = sc.nextLine();

                        idCliente=idCliente+1;

                        System.out.println("Dados de cliente computados. Agora vamos escolher o quarto. Precisa de banheiro?");
                        String respostaBanheiro = sc.next();
                        temBanheiro = respostaBanheiro.equalsIgnoreCase("S") || respostaBanheiro.equalsIgnoreCase("Sim");

                        System.out.println("Precisa de beliche?");
                        String respostaBeliche = sc.next();
                        ehBeliche = respostaBeliche.equalsIgnoreCase("S") || respostaBeliche.equalsIgnoreCase("Sim");


                        System.out.println("Quantidade de camas necessárias?");
                        qtdeCamas = sc.nextInt();

                        idQuarto = idQuarto+1;
                        idCama = idCama+1;

                        nomeQuarto = "Quarto " + idQuarto;
                        codigoCama = "Cama " + idCama;

                        Cliente novoCliente = new Cliente(idCliente, nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
                        Quarto novoQuarto = new Quarto(idQuarto, nomeQuarto, qtdeCamas, temBanheiro, "");
                        Cama novaCama = new Cama(idCama, codigoCama, ehBeliche, posicaoCama, descricaoCama);
                        Reserva novaReserva = new Reserva(idReserva, novoQuarto, novaCama, novoCliente, dataEntrada, dataSaida);

                        lReserva.add(novaReserva);
                        lCliente.add(novoCliente);
                        lQuarto.add(novoQuarto);
                        lCama.add(novaCama);

                        System.out.println("Quer cadastrar nova Reserva? S para Sim, N para Não.");
                        respostaIncluir = sc.next();
                    }
                    break;

                case 2:

                    System.out.println("Listar reservas: ");

                    for (Reserva reserva : lReserva) {
                        System.out.println(reserva.detReserva());
                    }

                    break;

                case 3:

                    System.out.println("Listar 1 reserva:  ");
                    System.out.println("Digite seu CPF:  ");

                    idBuscar = sc.nextInt();

                    reservaEncontrada = false;

                    for (Cliente clienteBuscado : lCliente) {
                        if (clienteBuscado.getCpf() == idBuscar) {
                            for (Reserva reserva : clienteBuscado.getReservas()) {
                                System.out.println(reserva.detReserva());
                            }
                            reservaEncontrada = true;
                            break;
                        }
                    }

                    if (!reservaEncontrada) {
                        System.out.println("Nenhuma reserva encontrada no CPF informado.");
                    }
                    break;

                case 4:
                    System.out.println("Alterar uma reserva");
                    System.out.println("Digite o CPF do usuário: ");
                    cpf = sc.nextInt();

                    reservaEncontrada = false;

                    for (Reserva reserva : lReserva) {
                        if (reserva.getCliente().getCpf() == cpf) {
                            System.out.println("Detalhes da reserva antiga:");
                            System.out.println(reserva.detReserva());

                            System.out.println("Qual campo deseja alterar?");
                            System.out.println("1 - Data de Entrada");
                            System.out.println("2 - Data de Saída");
                            System.out.println("3 - ID do Quarto");
                            System.out.println("4 - ID da Cama");
                            System.out.println("5 - Precisa de banheiro");
                            System.out.println("6 - Precisa de beliche");

                            int campo = sc.nextInt();

                            switch (campo) {
                                case 1:
                                    System.out.println("Digite a nova data de entrada: ");
                                    sc.nextLine();
                                    String novaDataEntrada = sc.nextLine();
                                    reserva.setDataEntrada(novaDataEntrada);
                                    break;

                                case 2:
                                    System.out.println("Digite a nova data de saída: ");
                                    sc.nextLine();
                                    String novaDataSaida = sc.nextLine();
                                    reserva.setDataSaida(novaDataSaida);
                                    break;

                                case 3:
                                    System.out.println("Digite o novo ID do quarto: ");
                                    int novoIdQuarto = sc.nextInt();
                                    Quarto novoQuarto = new Quarto(novoIdQuarto, "", 0, false, "");
                                    reserva.setQuarto(novoQuarto);
                                    break;

                                case 4:
                                    System.out.println("Digite o novo ID da cama: ");
                                    int novoIdCama = sc.nextInt();
                                    Cama novaCama = new Cama(novoIdCama, "", false, "", "");
                                    reserva.setCama(novaCama);
                                    break;

                                case 5:
                                    System.out.println("Precisa de banheiro? (S/N): ");
                                    String respostaBanheiro = sc.next();
                                    temBanheiro = respostaBanheiro.equalsIgnoreCase("S") || respostaBanheiro.equalsIgnoreCase("Sim");
                                    reserva.getQuarto().setTemBanheiro(temBanheiro);
                                    break;

                                case 6:
                                    System.out.println("Precisa de beliche? (S/N): ");
                                    String respostaBeliche = sc.next();
                                    ehBeliche = respostaBeliche.equalsIgnoreCase("S") || respostaBeliche.equalsIgnoreCase("Sim");
                                    reserva.getCama().setEhBeliche(ehBeliche);
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }

                            System.out.println("Reserva alterada com sucesso.");
                            reservaEncontrada = true;
                            break;
                        }
                    }

                    if (!reservaEncontrada) {
                        System.out.println("Nenhuma reserva encontrada no CPF informado.");
                    }
                    break;

                case 5:
                    System.out.println("Excluir uma reserva");
                    System.out.println("Digite o CPF do cliente: ");
                    cpf = sc.nextInt();

                    reservaEncontrada = false;
                    Reserva reservaExcluir = null;

                    for (Reserva reserva : lReserva) {
                        if (reserva.getCliente().getCpf() == cpf) {
                            reservaExcluir = reserva;
                            reservaEncontrada = true;
                            break;
                        }
                    }

                    if (reservaEncontrada) {
                        lReserva.remove(reservaExcluir);
                        System.out.println("Reserva excluída com sucesso.");
                    } else {
                        System.out.println("Nenhuma reserva encontrada no CPF informado.");
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
