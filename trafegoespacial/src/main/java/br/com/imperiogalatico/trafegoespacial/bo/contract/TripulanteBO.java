package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public interface TripulanteBO extends Serializable{
	public List<Tripulante> listar();
	public Tripulante buscarPorUrl(Tripulante tripulante);
}
