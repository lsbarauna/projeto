package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Nave;

public interface NaveBO {
	public List<Nave> listar();
	public Nave buscarPorUrl(Nave nave);
}
