package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.Comparator;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.bo.contract.NaveBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.util.Constantes;

public class NaveDefaultBO implements NaveBO{
	private SwapiBO swapi;
	
	
	public NaveDefaultBO() {
		super();
		swapi = new SwapiDefaultBO();
	}

	@Override
	public List<Nave> listar() {
		List<Nave> lista = swapi.listarNave(Constantes.URL_NAVE);
		ordernar(lista);
		return  lista;
	}

	@Override
	public Nave buscarPorUrl(Nave nave) {
		Nave naveRetorno = null;
		if(nave !=null && nave.getUrl() !=null){
			naveRetorno = swapi.buscarNave(nave.getUrl());
		}
		return naveRetorno;
	}
	
	public void ordernar(List<Nave> lista) {
		lista.sort(new Comparator<Nave>() {
			@Override
			public int compare(Nave o1, Nave o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
		});
	}

}
