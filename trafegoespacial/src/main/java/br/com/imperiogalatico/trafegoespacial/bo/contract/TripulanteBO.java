package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public interface TripulanteBO {
	public List<Tripulante> listar();
	public Tripulante buscarPorUrl(Tripulante tripulante);
}
