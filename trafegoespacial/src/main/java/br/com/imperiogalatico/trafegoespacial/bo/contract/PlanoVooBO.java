package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;


public interface PlanoVooBO extends Serializable{
	public void salvar(PlanoVoo planoVoo) throws Exception;
	public List<PlanoVoo> buscarTodos();
	public void excluir(List<PlanoVoo> listaPlanoSelected)  throws Exception;
	public PlanoVoo buscarPorCodigo(PlanoVoo planoVoo);
}
