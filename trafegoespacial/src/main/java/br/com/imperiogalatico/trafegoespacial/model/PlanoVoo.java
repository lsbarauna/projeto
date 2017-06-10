package br.com.imperiogalatico.trafegoespacial.model;

import java.util.List;

public class PlanoVoo {
	
	private Nave starship;
	private Planeta planet;
	private List<Tripulante> peoples;
	private Long codigo;	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Nave getStarship() {
		return starship;
	}
	public void setStarship(Nave starship) {
		this.starship = starship;
	}
	public Planeta getPlanet() {
		return planet;
	}
	public void setPlanet(Planeta planet) {
		this.planet = planet;
	}
	public List<Tripulante> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<Tripulante> peoples) {
		this.peoples = peoples;
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
