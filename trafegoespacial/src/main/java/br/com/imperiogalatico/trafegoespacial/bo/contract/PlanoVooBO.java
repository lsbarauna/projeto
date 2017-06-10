package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;


public interface PlanoVooBO extends Serializable{
	public void salvar(PlanoVoo planoVoo);
	public List<PlanoVoo> buscarTodos();
	public void excluir(List<PlanoVoo> listaPlanoSelected);
	public PlanoVoo buscarPorCodigo(PlanoVoo planoVoo);
}
