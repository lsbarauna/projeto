package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entidade básica
 * @author LUIS CARDOSO
 *
 */
public class PlanoVoo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Nave naveEspacial;
	private Planeta planetaDestino;
	private List<Tripulante> listaTripulante;
	private Long codigo;	
	private Date dataVoo;
	
	public PlanoVoo(Long codigo) {
		super();
		this.codigo = codigo;
	}
	public PlanoVoo() {
		listaTripulante = new ArrayList<Tripulante>();
		naveEspacial = new Nave();
		planetaDestino = new Planeta();
	}
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
	public Date getDataVoo() {
		return dataVoo;
	}
	public void setDataVoo(Date dataVoo) {
		this.dataVoo = dataVoo;
	}
	
	

}
