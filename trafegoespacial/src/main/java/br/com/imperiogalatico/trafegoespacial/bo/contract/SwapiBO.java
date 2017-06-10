package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public interface SwapiBO {

	public List<Planeta> listarPlaneta();
	public List<Tripulante> listarTripulante();
	public List<Nave> listarNave();
	
}
