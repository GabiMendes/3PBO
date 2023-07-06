package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

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

        //Precisa-se de CRUDs de administradores para CLIENTE, QUARTO E CAMA. Antes do SWITCH principal, perguntar se é administrador para poder realizar tais ações.
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

                        //Para dados booleanos, criar lógica condicional. Se cliente digitar "Sim" == TRUE, se não, FALSE.
                        System.out.println("Dados de cliente computados. Agora vamos escolher o quarto. Precisa de banheiro?");
                        temBanheiro = sc.hasNextBoolean();

                        System.out.println("Quantidade de camas necessárias?");
                        qtdeCamas = sc.nextInt();

                        //Para dados booleanos, criar lógica condicional. Se cliente digitar "Sim" == TRUE, se não, FALSE.
                        System.out.println("Precisa de beliche?");
                        ehBeliche = sc.hasNextBoolean();

                        idQuarto = idQuarto+1;
                        idCama = idCama+1;

                        Cliente novoCliente = new Cliente(idCliente, nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
                        Quarto novoQuarto = new Quarto(idQuarto, nomeQuarto, qtdeCamas, temBanheiro, "");
                        Cama novaCama = new Cama(idCama, "", ehBeliche, "", "");
                        Reserva novaReserva = new Reserva(idReserva, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                       
                        //Transformar em arquivo dados armazenados abaixo.
                        //Quartos e camas já precisam existir, alterar lógica do código e interação entre as classes.
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
                        //Criar classe "detReserva", que trará os detalhes de todas as reservas ocupadas para administrador da página.
                        //Se o cliente quiser conferir dados de sua reserva, case abaixo
                        System.out.println(reserva.detReserva());
                    }

                    break;

                case 3:

                    System.out.println("Listar 1 reserva:  ");
                    System.out.println("Digite seu CPF:  ");

                    idBuscar = sc.nextInt();

                    boolean cpfEncontrado = false;

                    for (Cliente clienteBuscado : lCliente) {
                        if (clienteBuscado.getCpf() == idBuscar) {
                            //Estabelecer dentro das classes cliente x reserva a relação entre as duas através do CPF.
                            System.out.println(reserva.detReserva());
                            reservaEncontrada = true;
                            //Cliente pode ter outras reservas, alterar lógica.
                            break;
                        }
                    }

                    if (!reservaEncontrada) {
                        System.out.println("Nenhuma reserva encontrada no CPF informado.");
                    }
                    break;

                    break;

                case 4:
                    //Alterar reserva
                    break;

                case 5:
                    //Excluir reserva
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
