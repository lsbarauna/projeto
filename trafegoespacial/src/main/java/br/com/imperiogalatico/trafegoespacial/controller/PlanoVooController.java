package br.com.imperiogalatico.trafegoespacial.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import br.com.imperiogalatico.trafegoespacial.bo.SwapiDefaultBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

@ManagedBean
@ViewScoped
public class PlanoVooController {
	private SwapiBO swapi;
	private List<Planeta> listaPlaneta;
	private Planeta planeta;
	private List<Nave> listaNave;
	private Nave nave;
	private List<Tripulante> listaTripulante;
	
	private List<PlanoVoo> listaPlanoVoo; 
	private List<PlanoVoo> listaPlanoSelected;
	private PlanoVoo planoVoo;
	public PlanoVooController() {
		swapi = new SwapiDefaultBO();
		listaNave = swapi.listarNave();
		listaPlaneta = swapi.listarPlaneta();
		listaTripulante= swapi.listarTripulante();
		planeta = new Planeta();

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

	public String salvar() {
		System.out.println("eeeeeeeeeeeeeeeeeeeee"+planeta.getUrl());
		return "manterPlanoVoo";
	}
	
	public String excluir() {
		return "manterPlanoVoo";
	}
	
	public String editar() {
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

	
	public SwapiBO getSwapi() {
		return swapi;
	}



	public void setSwapi(SwapiBO swapi) {
		this.swapi = swapi;
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

}
