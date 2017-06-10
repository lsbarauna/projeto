package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.TripulanteBO;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;
import br.com.imperiogalatico.trafegoespacial.util.Constantes;

public class TripulanteDefaultBO implements TripulanteBO{
	
	@Inject
	private SwapiBO swapi;

	@Override
	public List<Tripulante> listar() {
		List<Tripulante> lista = swapi.listarTripulante(Constantes.URL_TRIPULANTE);
		ordernar(lista);
		return lista;
	}

	@Override
	public Tripulante buscarPorUrl(Tripulante tripulante) {
		Tripulante tripulanteRetorno = null;
		if(tripulante !=null && tripulante.getUrl() !=null){
			tripulanteRetorno = swapi.buscarTripulante(tripulante.getUrl());
		}
		return tripulanteRetorno;
	}
	
	public void ordernar(List<Tripulante> lista) {
		lista.sort(new Comparator<Tripulante>() {
			@Override
			public int compare(Tripulante o1, Tripulante o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
		});
	}

}
