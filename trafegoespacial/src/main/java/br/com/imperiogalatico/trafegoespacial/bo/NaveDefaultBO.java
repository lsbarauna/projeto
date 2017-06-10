package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.bo.contract.NaveBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.util.Constantes;

public class NaveDefaultBO implements NaveBO{
	
	@Inject
	private SwapiBO swapi;
	

	@Override
	public List<Nave> listar() {
		return swapi.listarNave(Constantes.URL_NAVE);
	}

	@Override
	public Nave buscarPorUrl(Nave nave) {
		Nave naveRetorno = null;
		if(nave !=null && nave.getUrl() !=null){
			naveRetorno = swapi.buscarNave(nave.getUrl());
		}
		return naveRetorno;
	}

}
