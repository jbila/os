package model;

import java.time.LocalDate;

public abstract class AbstractEntity {
	private int id;
	private String nome;
	private  LocalDate dataCriacao;
	private  LocalDate dataActualizacao;
	
	
	
	public AbstractEntity() {
		dataCriacao=LocalDate.now();
		
	}
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
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataActualizacao() {
		return dataActualizacao;
	}
	public void setDataActualizacao(LocalDate dataActualizacao) {
		this.dataActualizacao = dataActualizacao;
	}
	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", dataActualizacao="
				+ dataActualizacao + "]";
	}
	
	

}
