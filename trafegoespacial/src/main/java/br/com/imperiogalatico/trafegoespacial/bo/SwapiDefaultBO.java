package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;
import br.com.imperiogalatico.trafegoespacial.service.client.SwapiClient;

public class SwapiDefaultBO implements SwapiBO {

	private SwapiClient swapiClient;
	
	private SwapiDefaultBO(){
		swapiClient =  new SwapiClient();
	}

	@Override
	public List<Planeta> listarPlaneta() {
		return swapiClient.listarPlaneta();
	}

	@Override
	public List<Tripulante> listarTripulante() {
		return swapiClient.listarTripulante();
	}

	@Override
	public List<Nave> listarNave() {
		return swapiClient.listarNave();
	}
	
}
