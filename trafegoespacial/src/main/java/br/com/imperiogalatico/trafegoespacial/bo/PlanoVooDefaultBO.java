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
		if(planoVoo != null && planoVoo.getCodigo() != null){
			planoVooDAO.atualizar(planoVoo); 
		}else{
			planoVooDAO.adicionar(planoVoo);
		}
		
	}
	
	public void validacaoCamposObrigatorios(PlanoVoo planoVoo) throws Exception{
		if(planoVoo.getPlanetaDestino() == null){
			throw new Exception("Favor informar um Planeta!");
		}
		if(planoVoo.getNaveEspacial() == null){
			throw new Exception("Favor informar uma Nave Espacial!");
		}		
		if(planoVoo.getListaTripulante() == null || planoVoo.getListaTripulante().size() == 0 ){
			throw new Exception("Favor informar pelo menos 1 Tripulante!");
		}
		
	}
	
	public void validacaoRegraDeNegocio(PlanoVoo planoVoo) throws Exception{		
		
		if(planoVoo.getListaTripulante().size() > planoVoo.getNaveEspacial().getPassengers().intValue() ){
			throw new Exception("A quantidade de Tripulante não pode exceder a capacidade da Nave Espacial!");
		}
	}
	public void buscarUltimoPlanoDeVoo(PlanoVoo planoVoo) {
		if(planoVoo.getCodigo() == null){
			List<PlanoVoo> lista = buscarTodos();
			if(lista!=null && lista.size() > 0){
				
			}
		}
		
	}
	public PlanoVooDAO getPlanoVooDAO() {
		return planoVooDAO;
	}

	public void setPlanoVooDAO(PlanoVooDAO planoVooDAO) {
		this.planoVooDAO = planoVooDAO;
	}

	@Override
	public List<PlanoVoo> buscarTodos() {
		return planoVooDAO.buscarTodos();
	}

	@Override
	public void excluir(List<PlanoVoo> listaPlanoSelected) {
		planoVooDAO.excluir(listaPlanoSelected);
		
	}

	@Override
	public PlanoVoo buscarPorCodigo(PlanoVoo planoVoo) {
		return planoVooDAO.buscarPorChave(planoVoo);
	}
	
	

}
