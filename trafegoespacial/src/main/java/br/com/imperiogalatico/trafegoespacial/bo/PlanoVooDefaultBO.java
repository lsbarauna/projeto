package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import javax.inject.Inject;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.dao.contract.PlanoVooDAO;
import br.com.imperiogalatico.trafegoespacial.exception.ApplicationException;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

public class PlanoVooDefaultBO implements PlanoVooBO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530902364658825004L;
	@Inject
	private PlanoVooDAO planoVooDAO;	
	

	public PlanoVooDefaultBO() {
	}

	@Override
	public void salvar(PlanoVoo planoVoo) throws ApplicationException {
		validacao(planoVoo);
		if(planoVoo != null && planoVoo.getCodigo() != null){
			planoVooDAO.atualizar(planoVoo); 
		}else{
			planoVooDAO.adicionar(planoVoo);
		}
		
	}
	
	public void validacao(PlanoVoo planoVoo) throws ApplicationException{
		validacaoCamposObrigatorios(planoVoo);
		validacaoRegraDeNegocio(planoVoo);
	}
	public void validacaoCamposObrigatorios(PlanoVoo planoVoo) throws ApplicationException{
		if(planoVoo.getPlanetaDestino() == null){
			throw new ApplicationException("Favor informar um Planeta!");
		}
		if(planoVoo.getNaveEspacial() == null){
			throw new ApplicationException("Favor informar uma Nave Espacial!");
		}		
		if(planoVoo.getListaTripulante() == null || planoVoo.getListaTripulante().size() == 0 ){
			throw new ApplicationException("Favor informar pelo menos 1 Tripulante!");
		}
		
	}
	
	public void validacaoRegraDeNegocio(PlanoVoo planoVoo) throws ApplicationException{	
		
		if(planoVoo.getListaTripulante().size() > planoVoo.getNaveEspacial().getPassengers().intValue() ){
			throw new ApplicationException("A quantidade de tripulantes não pode ser maior que a capacidade da Nave.!");
		}
		
		PlanoVoo planoAnterior = buscarAnterior(planoVoo);
		if(planoAnterior != null && planoAnterior.getPlanetaDestino().equals(planoVoo.getPlanetaDestino())){
			throw new ApplicationException("O Planeta destino não pode ser o mesmo que o voo anterior!");
		}
	}
	
	public PlanoVoo buscarAnterior(PlanoVoo planoVoo) {
		PlanoVoo planoAnterior = null;
		
		List<PlanoVoo> listaPlanos = buscarTodos();
		if(listaPlanos !=null && listaPlanos.size() >0){
			int posicao = listaPlanos.indexOf(planoVoo) ;
			if(posicao > 0){
				planoAnterior = listaPlanos.get((posicao-1));
			}else{
				planoAnterior = listaPlanos.get((listaPlanos.size() - 1));
			}
		}
		return planoAnterior;
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
