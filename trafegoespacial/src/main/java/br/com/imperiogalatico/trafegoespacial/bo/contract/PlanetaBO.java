package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Planeta;

public interface PlanetaBO  extends Serializable{
	public List<Planeta> listar();
	public Planeta buscarPorUrl(Planeta planeta);
}
