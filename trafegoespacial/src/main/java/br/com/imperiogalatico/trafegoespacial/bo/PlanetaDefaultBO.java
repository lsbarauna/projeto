package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.util.Constantes;

public class PlanetaDefaultBO implements PlanetaBO{
	
	@Inject
	private SwapiBO swapi;
	
	
	public PlanetaDefaultBO() {
	}

	@Override
	public List<Planeta> listar() {
		return swapi.listarPlaneta(Constantes.URL_PLANETA);
	}

	@Override
	public Planeta buscarPorUrl(Planeta planeta) {
		Planeta planetaRetorno = null;
		if(planeta !=null && planeta.getUrl() !=null){
			planetaRetorno = swapi.buscarPlaneta(planeta.getUrl());
		}
		return planetaRetorno;
	}

}
