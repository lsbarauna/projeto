package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public interface SwapiBO extends Serializable{

	public List<Planeta> listarPlaneta(String url);
	public List<Tripulante> listarTripulante(String url);
	public List<Nave> listarNave(String url);
	
	public Nave buscarNave(String url) ;
	public Planeta buscarPlaneta(String url);
	public Tripulante buscarTripulante(String url);
	
	
	
}
