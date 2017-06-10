package br.com.imperiogalatico.trafegoespacial.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.imperiogalatico.trafegoespacial.model.Planeta;
@FacesConverter(value = "planetaConverter",forClass=br.com.imperiogalatico.trafegoespacial.model.Planeta.class) 
public class PlanetaConverter implements Converter { 

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) { 
		Object ret = null; 
		if(arg2 !=null){
			ret = new Planeta();
			((Planeta)ret).setUrl(arg2);
			
		}
		System.out.println(">>>>>>>"+ret);
		return ret; 
	} 

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) { 
		String str = ""; 
		if (arg2 instanceof Planeta) 
			str = ((Planeta) arg2).getUrl().toString(); 
		
		System.out.println(">>>>>>>"+arg2);
		return str; 
	} 
} 
