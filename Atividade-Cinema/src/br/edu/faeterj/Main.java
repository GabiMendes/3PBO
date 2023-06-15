package br.edu.faeterj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String novoProcesso = "S";

        ArrayList<Cinema.Filme> listaFilmes = new ArrayList<>();

        while (novoProcesso.equalsIgnoreCase("S")) {
            System.out.println("Selecione o tipo de usuário:");
            System.out.println("1 - Administrador");
            System.out.println("2 - Cliente");
            int tipoUsuario = scanner.nextInt();

            if (tipoUsuario == 1) {
                // Usuário é administrador
                System.out.println("Preencha os dados do filme:");

                scanner.nextLine();

                System.out.print("Título: ");
                String titulo = scanner.nextLine();

                System.out.print("Diretor: ");
                String diretor = scanner.nextLine();

                System.out.print("Ano de lançamento: ");
                int anoLancamento = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Gênero: ");
                String genero = scanner.next();

                System.out.print("Duração: ");
                String duracao = scanner.next();

                System.out.print("Classificação: ");
                String classificacao = scanner.next();

                scanner.nextLine();

                System.out.print("Sinopse: ");
                String sinopse = scanner.nextLine();

                Cinema.Filme filme = new Cinema.Filme(titulo, diretor, anoLancamento, genero, duracao, classificacao, sinopse);

                listaFilmes.add(filme);

                // Exibição dos dados preenchidos
                System.out.println("\nDados do filme:");
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Diretor: " + filme.getDiretor());
                System.out.println("Ano de lançamento: " + filme.getAnoLancamento());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("Duração: " + filme.getDuracao());
                System.out.println("Classificação: " + filme.getClassificacao());
                System.out.println("Sinopse: " + filme.getSinopse());
            } else if (tipoUsuario == 2) {
                Cinema.Cliente cliente = null;

                // Usuário é cliente
                System.out.println("Preencha os dados pessoais:");

                scanner.nextLine();

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Cpf: ");
                String cpf = scanner.nextLine();

                System.out.print("Celular: ");
                int celular = scanner.nextInt();

                System.out.print("Idade: ");
                int idade = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Preencha os dados da sessão:");

                System.out.print("Filme: ");
                String filmeNome = scanner.nextLine();

                boolean filmeExiste = false;
                Cinema.Filme filmeSelecionado = null;
                for (Cinema.Filme filmeArmazenado : listaFilmes) {
                    if (filmeArmazenado.getTitulo().equalsIgnoreCase(filmeNome)) {
                        filmeExiste = true;
                        filmeSelecionado = filmeArmazenado;
                        break;
                    }
                }

                if (!filmeExiste) {
                    System.out.println("O filme selecionado não está disponível para reserva.");
                    continue;
                }

                System.out.print("Horário (formato 00h00min): ");
                String horario = scanner.nextLine();

                System.out.print("Dia: ");
                String dia = scanner.nextLine();

                Cinema.Sala sala = new Cinema.Sala();

                Cinema.Sessao sessao = new Cinema.Sessao(sala, filmeSelecionado, horario, dia);

                cliente = new Cinema.Cliente(nome, cpf, celular, idade, sessao);

                // Exibição dos dados da sessão
                System.out.println("\nDados da sessão:");
                System.out.println("Filme: " + cliente.getSessao().getFilme().getTitulo());
                System.out.println("Sinopse: " + cliente.getSessao().getFilme().getSinopse());
                System.out.println("Diretor: " + cliente.getSessao().getFilme().getDiretor());
                System.out.println("Horário: " + cliente.getSessao().getHorario());
                System.out.println("Dia: " + cliente.getSessao().getDia());
            }

            System.out.print("\nDeseja realizar um novo processo? (S/N): ");
            novoProcesso = scanner.next();
        }
    }
}
