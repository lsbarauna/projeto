package br.com.imperiogalatico.trafegoespacial.business.bo.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.NaveEspacial;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public interface SwapiBO {

	public List<Planeta> listarPlaneta();
	public List<Tripulante> listarTripulante();
	public List<NaveEspacial> listarNaveEspacial();
	
}
