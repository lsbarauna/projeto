package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Planeta;

public interface PlanetaBO {
	public List<Planeta> listar();
	public Planeta buscarPorUrl(Planeta planeta);
}
