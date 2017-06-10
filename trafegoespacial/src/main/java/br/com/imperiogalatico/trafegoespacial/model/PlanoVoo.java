package br.com.imperiogalatico.trafegoespacial.model;

import java.util.List;

public class PlanoVoo {
	private Nave naveEspacial;
	private Planeta planetaDestino;
	private List<Tripulante> listaTripulante;
	private Long codigo;	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Nave getNaveEspacial() {
		return naveEspacial;
	}
	public void setNaveEspacial(Nave naveEspacial) {
		this.naveEspacial = naveEspacial;
	}
	public Planeta getPlanetaDestino() {
		return planetaDestino;
	}
	public void setPlanetaDestino(Planeta planetaDestino) {
		this.planetaDestino = planetaDestino;
	}
	public List<Tripulante> getListaTripulante() {
		return listaTripulante;
	}
	public void setListaTripulante(List<Tripulante> listaTripulante) {
		this.listaTripulante = listaTripulante;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoVoo other = (PlanoVoo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
