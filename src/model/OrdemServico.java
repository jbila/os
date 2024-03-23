package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrdemServico {

    private int id;
    private String equipamento;
    private String status;
    private String avaria;
    private String servico;
    private String operacao;// ENTRADA| SAIDA
    private double valor;
    private double iva;
    private LocalDate data;
    private LocalDateTime hora;
    private Cliente cliente;
    private Tecnico tecnico;

    public OrdemServico() {
        data = LocalDate.now();
        hora = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id=" + id + ", equipamento=" + equipamento + ", status=" + status + ", avaria=" + avaria + ", servico=" + servico + ", operacao=" + operacao + ", valor=" + valor + ", iva=" + iva + ", data=" + data + ", hora=" + hora + ", cliente=" + cliente + ", tecnico=" + tecnico + '}';
    }

}
