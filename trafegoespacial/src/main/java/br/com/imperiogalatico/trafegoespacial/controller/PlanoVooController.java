package br.com.imperiogalatico.trafegoespacial.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.imperiogalatico.trafegoespacial.bo.NaveDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.PlanetaDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.PlanoVooDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.SwapiDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.TripulanteDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.NaveBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.TripulanteBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

@ManagedBean
@ViewScoped
public class PlanoVooController {
	private PlanetaBO planetaBO;
	private NaveBO naveBO;
	private TripulanteBO tripulanteBO;	
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
	
	public PlanoVooController() {
		planetaBO = new PlanetaDefaultBO() ;
		naveBO = new NaveDefaultBO();
		tripulanteBO = new TripulanteDefaultBO();
		nave = new Nave();
		planeta = new Planeta();
		planoVooBO = new PlanoVooDefaultBO();
		planoVoo = new PlanoVoo();

	}
	
	@PostConstruct
	public void iniciarCombos(){
		listaPlaneta = planetaBO.listar();
		listaNave = naveBO.listar();		
		listaTripulante = tripulanteBO.listar();
		listaPlanoVoo = planoVooBO.buscarTodos();
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
		planoVoo = new PlanoVoo();
		
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
		return "manterPlanoVoo";
	}
	
	public String excluir() {
		planoVooBO.excluir(listaPlanoSelected);
		return "manterPlanoVoo";
	}
	
	public PlanoVoo getPlanoVooDetalhe() {
		return planoVooDetalhe;
	}

	public void setPlanoVooDetalhe(PlanoVoo planoVooDetalhe) {
		this.planoVooDetalhe = planoVooDetalhe;
	}

	public String editar() {
		return "cadastroPlanoVoo";
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
