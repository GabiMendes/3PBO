package br.edu.faeterj;
public class Cinema {
    public static class Filme {
        private String titulo;
        private String diretor;
        private int anoLancamento;
        private String genero;
        private String duracao;
        private String classificacao;
        private String sinopse;

        public Filme(String titulo, String diretor, int anoLancamento, String genero, String duracao, String classificacao, String sinopse) {
            this.titulo = titulo;
            this.diretor = diretor;
            this.anoLancamento = anoLancamento;
            this.genero = genero;
            this.duracao = duracao;
            this.classificacao = classificacao;
            this.sinopse = sinopse;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDiretor() {
            return diretor;
        }

        public int getAnoLancamento() {
            return anoLancamento;
        }

        public String getGenero() {
            return genero;
        }

        public String getDuracao() {
            return duracao;
        }

        public String getClassificacao() {
            return classificacao;
        }

        public String getSinopse() {
            return sinopse;
        }
    }

    public static class Sala {
        // Implementação da classe Sala
    }

    public static class Sessao {
        private Sala sala;
        private Filme filme;
        private String horario;
        private String dia;

        public Sessao(Sala sala, Filme filme, String horario, String dia) {
            this.sala = sala;
            this.filme = filme;
            this.horario = horario;
            this.dia = dia;
        }

        public Sala getSala() {
            return sala;
        }

        public void setSala(Sala sala) {
            this.sala = sala;
        }

        public Filme getFilme() {
            return filme;
        }

        public void setFilme(Filme filme) {
            this.filme = filme;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }
    }

    public static class Cliente {
        private String nome;
        private String cpf;
        private int celular;
        private int idade;
        private Sessao sessao;

        public Cliente(String nome, String cpf, int celular, int idade, Sessao sessao) {
            this.nome = nome;
            this.cpf = cpf;
            this.celular = celular;
            this.idade = idade;
            this.sessao = sessao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public int getCelular() {
            return celular;
        }

        public void setCelular(int celular) {
            this.celular = celular;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public Sessao getSessao() {
            return sessao;
        }

        public void setSessao(Sessao sessao) {
            this.sessao = sessao;
        }
    }
}
