package br.com.imperiogalatico.trafegoespacial.dao.contract;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

public interface PlanoVooDAO {

	void adicionar(PlanoVoo planoDeVoo);

	PlanoVoo buscarPorChave(PlanoVoo chave);

	List<PlanoVoo> buscarTodos();

	void limparBase();

	long getSeqPlanoDeVooNextVal();
	
	void excluir(List<PlanoVoo> listaPlanoSelected);

}