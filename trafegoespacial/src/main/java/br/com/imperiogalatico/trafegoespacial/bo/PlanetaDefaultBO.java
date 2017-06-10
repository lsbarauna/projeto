package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.Comparator;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.util.Constantes;

public class PlanetaDefaultBO implements PlanetaBO{
	private SwapiBO swapi;
	
	
	public PlanetaDefaultBO() {
		super();
		swapi = new SwapiDefaultBO();
	}

	@Override
	public List<Planeta> listar() {
		List<Planeta> lista = swapi.listarPlaneta(Constantes.URL_PLANETA);
		ordernar(lista);
		return lista;
	}

	@Override
	public Planeta buscarPorUrl(Planeta planeta) {
		Planeta planetaRetorno = null;
		if(planeta !=null && planeta.getUrl() !=null){
			planetaRetorno = swapi.buscarPlaneta(planeta.getUrl());
		}
		return planetaRetorno;
	}
	
	public void ordernar(List<Planeta> lista) {
		lista.sort(new Comparator<Planeta>() {
			@Override
			public int compare(Planeta o1, Planeta o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
		});
	}

}
