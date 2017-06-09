package br.com.imperiogalatico.trafegoespacial.model;

public class NaveEspacial {
	private String nome;
	private String modelo;
	private Long capacidadePassageiro;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getCapacidadePassageiro() {
		return capacidadePassageiro;
	}
	public void setCapacidadePassageiro(Long capacidadePassageiro) {
		this.capacidadePassageiro = capacidadePassageiro;
	}
	
	
	
}
