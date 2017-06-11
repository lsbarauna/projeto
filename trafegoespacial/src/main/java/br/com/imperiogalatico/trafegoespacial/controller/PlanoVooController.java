package br.com.imperiogalatico.trafegoespacial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.bo.contract.NaveBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.TripulanteBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

@Named
@ViewScoped
public class PlanoVooController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlanetaBO planetaBO;
	
	@Inject
	private NaveBO naveBO;
	
	@Inject
	private TripulanteBO tripulanteBO;
	
	@Inject
	private PlanoVooBO planoVooBO;
	
	private List<Planeta> listaPlaneta;
	private Planeta planeta;
	private List<Nave> listaNave;
	private Nave nave;
	private List<Tripulante> listaTripulante;	
	private List<Tripulante> listaTripulanteSelected;
	private List<PlanoVoo> listaPlanoVoo; 
	private List<PlanoVoo> listaPlanoSelected;
	private PlanoVoo planoVoo;
	private PlanoVoo planoVooDetalhe;
	
	@PostConstruct
	public void init(){
		listaPlanoVoo = planoVooBO.buscarTodos();
	}
	
	public void initCadastroPlanoVoo(Long codigo){
		
		if(codigo!=null){
			planoVoo = planoVooBO.buscarPorCodigo(new PlanoVoo(codigo));
			planeta = planoVoo.getPlanetaDestino();
			nave = planoVoo.getNaveEspacial();
			listaTripulanteSelected = planoVoo.getListaTripulante();
		}else{
			planoVoo = new PlanoVoo();
			nave = new Nave();
			planeta = new Planeta();
		}
		
		listaPlaneta = planetaBO.listar();
		listaNave = naveBO.listar();		
		listaTripulante = tripulanteBO.listar();
	}

	public List<PlanoVoo> getListaPlanoSelected() {
		return listaPlanoSelected;
	}



	public void setListaPlanoSelected(List<PlanoVoo> listaPlanoSelected) {
		this.listaPlanoSelected = listaPlanoSelected;
	}



	public List<PlanoVoo> getListaPlanoVoo() {
		return listaPlanoVoo;
	}

	public void setListaPlanoVoo(List<PlanoVoo> listaPlanoVoo) {
		this.listaPlanoVoo = listaPlanoVoo;
	}

	public PlanoVoo getPlanoVoo() {
		return planoVoo;
	}

	public void setPlanoVoo(PlanoVoo planoVoo) {
		this.planoVoo = planoVoo;
	}

	public String detalhe() {
		System.out.println(planoVooDetalhe);
		return null;
	}
	public String salvar() {
		if(planoVoo == null || planoVoo.getCodigo() == null){
			planoVoo = new PlanoVoo();
		}else{
			planoVoo.setListaTripulante(new ArrayList<Tripulante>());
		}
		
		Planeta lPlaneta = planetaBO.buscarPorUrl(planeta);
		Nave lNave = naveBO.buscarPorUrl(nave);
		planoVoo.setNaveEspacial(lNave);
		planoVoo.setPlanetaDestino(lPlaneta);
		if(listaTripulanteSelected != null && listaTripulanteSelected.size() > 0){
			for(Tripulante tripulante : listaTripulanteSelected){
				tripulante = tripulanteBO.buscarPorUrl(tripulante);
				planoVoo.getListaTripulante().add(tripulante);
			}
		}
		
		planoVooBO.salvar(planoVoo);
		saveMessage("registro cadastrado com sucesso!");
		return "manterPlanoVoo";
	}
	public void saveMessage(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage("Sucesso",  mensagem) );
    }
	
	
	public String excluir() {
		planoVooBO.excluir(listaPlanoSelected);
		saveMessage("registro(s) excluído(s) com sucesso!");
		return null;
	}
	
	public PlanoVoo getPlanoVooDetalhe() {
		return planoVooDetalhe;
	}

	public void setPlanoVooDetalhe(PlanoVoo planoVooDetalhe) {
		this.planoVooDetalhe = planoVooDetalhe;
	}

	public String editar(Long codigo) {
		return "cadastroPlanoVoo?faces-redirect=true&codigo="+codigo;
	}
	
	public String novo() {
		return "cadastroPlanoVoo";
	}

	public List<Nave> getListaNave() {
		return listaNave;
	}

	public void setListaNave(List<Nave> listaNave) {
		this.listaNave = listaNave;
	}

	public Nave getNave() {
		return nave;
	}

	public List<Tripulante> getListaTripulante() {
		return listaTripulante;
	}

	public void setListaTripulante(List<Tripulante> listaTripulante) {
		this.listaTripulante = listaTripulante;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public List<Planeta> getListaPlaneta() {
		return listaPlaneta;
	}

	public void setListaPlaneta(List<Planeta> listaPlaneta) {
		this.listaPlaneta = listaPlaneta;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public List<Tripulante> getListaTripulanteSelected() {
		return listaTripulanteSelected;
	}

	public void setListaTripulanteSelected(List<Tripulante> listaTripulanteSelected) {
		this.listaTripulanteSelected = listaTripulanteSelected;
	}

}
