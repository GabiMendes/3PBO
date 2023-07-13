package br.edu.faeterj;
import java.util.ArrayList;

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
}
