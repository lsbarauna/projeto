package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.dao.PlanoVooMemoryDAO;
import br.com.imperiogalatico.trafegoespacial.dao.contract.PlanoVooDAO;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

public class PlanoVooDefaultBO implements PlanoVooBO{
	private PlanoVooDAO planoVooDAO;
	
	

	public PlanoVooDefaultBO() {
		planoVooDAO = new PlanoVooMemoryDAO();
	}

	@Override
	public void salvar(PlanoVoo planoVoo) {
		planoVooDAO.adicionar(planoVoo);
	}

	@Override
	public List<PlanoVoo> buscarTodos() {
		return planoVooDAO.buscarTodos();
	}

	@Override
	public void excluir(List<PlanoVoo> listaPlanoSelected) {
		planoVooDAO.excluir(listaPlanoSelected);
		
	}
	
	

}
