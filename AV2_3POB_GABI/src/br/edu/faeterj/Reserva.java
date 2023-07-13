package br.edu.faeterj;

public class Reserva {

    private int id;
    private Quarto quarto;
    private Cama cama;
    private Cliente cliente;
    private String dataEntrada;
    private String dataSaida;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    public Cama getCama() {
        return cama;
    }
    public void setCama(Cama cama) {
        this.cama = cama;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
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

    public Reserva(int id, Quarto quarto, Cama cama, Cliente cliente, String dataEntrada, String dataSaida) {
        this.id = id;
        this.quarto = quarto;
        this.cama = cama;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        cliente.addReserva(this);
    }

    public String detReserva() {
        String result = "ID: " + id +
                ", ID do Quarto: " + quarto.getId() +
                ", ID da Cama: " + cama.getId() +
                ", ID do Cliente: " + cliente.getId() +
                ", Necessita de Banheiro? " + quarto.isTemBanheiro() +
                ", Quantas camas?  " + quarto.getQtdeCamas() +
                ", Necessita de Beliche?  " + cama.isEhBeliche() +
                ", Data de Entrada: " + dataEntrada +
                ", Data de Saída: " + dataSaida;
        return result;
    }
}
