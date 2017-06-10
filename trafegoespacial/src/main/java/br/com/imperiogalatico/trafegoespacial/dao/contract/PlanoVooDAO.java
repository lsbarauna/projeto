package br.com.imperiogalatico.trafegoespacial.dao.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

public interface PlanoVooDAO  extends Serializable{

	void adicionar(PlanoVoo planoDeVoo);
	
	void atualizar(PlanoVoo planoDeVoo);

	PlanoVoo buscarPorChave(PlanoVoo chave);

	List<PlanoVoo> buscarTodos();

	void limparBase();

	long getSeqPlanoDeVooNextVal();
	
	void excluir(List<PlanoVoo> listaPlanoSelected);
	
	PlanoVoo buscarPorCodigo(PlanoVoo planoVoo);

}