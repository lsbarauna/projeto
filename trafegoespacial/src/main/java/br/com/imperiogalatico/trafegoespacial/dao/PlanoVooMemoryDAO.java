package br.com.imperiogalatico.trafegoespacial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.dao.contract.PlanoVooDAO;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

public class PlanoVooMemoryDAO implements PlanoVooDAO {
	private static long seqPlanoDeVoo;
	public static List<PlanoVoo> listaPlanoDeVoo = new ArrayList<PlanoVoo>();
	
	
	
	/* (non-Javadoc)
	 * @see br.com.imperiogalatico.trafegoespacial.persistence.PlanoDeVoo#adicionar(br.com.imperiogalatico.trafegoespacial.model.PlanoDeVooDTO)
	 */
	@Override
	public void adicionar(PlanoVoo planoDeVoo){
		planoDeVoo.setCodigo(getSeqPlanoDeVooNextVal());
		listaPlanoDeVoo.add( planoDeVoo);
	}
		
	
	/* (non-Javadoc)
	 * @see br.com.imperiogalatico.trafegoespacial.persistence.PlanoDeVoo#buscarPorChave(br.com.imperiogalatico.trafegoespacial.model.PlanoDeVooDTO)
	 */
	@Override
	public PlanoVoo buscarPorChave(PlanoVoo chave){
		return listaPlanoDeVoo.stream().filter(planoDeVoo -> planoDeVoo.equals(chave)).findAny().orElse(null);
	}

	
	/* (non-Javadoc)
	 * @see br.com.imperiogalatico.trafegoespacial.persistence.PlanoDeVoo#buscarTodos()
	 */
	@Override
	public List<PlanoVoo> buscarTodos(){
			return listaPlanoDeVoo;
	}
	
	public void excluir(List<PlanoVoo> listaPlanoSelected) {
		if(listaPlanoSelected != null && listaPlanoSelected.size() > 0){
			for(PlanoVoo planoVoo:listaPlanoSelected){
				listaPlanoDeVoo.remove(planoVoo);
			}
		}
		
	}
	
	public PlanoVoo buscarPorCodigo(PlanoVoo chave) {
		return listaPlanoDeVoo.stream().filter(planoVoo -> planoVoo.equals(chave)).findAny().orElse(null);
	}

	
	/* (non-Javadoc)
	 * @see br.com.imperiogalatico.trafegoespacial.persistence.PlanoDeVoo#limparBase()
	 */
	@Override
	public void limparBase() {
		listaPlanoDeVoo = new ArrayList<PlanoVoo>();
		
	}
	
	

	
	@Override
	public void atualizar(PlanoVoo planoDeVoo) {
		int indice = listaPlanoDeVoo.indexOf(planoDeVoo);
		if(indice > -1){
			listaPlanoDeVoo.set(indice,planoDeVoo);
		}
		
	}


	/* (non-Javadoc)
	 * @see br.com.imperiogalatico.trafegoespacial.persistence.PlanoDeVoo#getSeqPlanoDeVooNextVal()
	 */
	@Override
	public long getSeqPlanoDeVooNextVal(){
		seqPlanoDeVoo+=1;
		return seqPlanoDeVoo;
		
	}
}
