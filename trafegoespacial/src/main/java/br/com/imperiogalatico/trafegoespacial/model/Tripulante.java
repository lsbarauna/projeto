package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;


public class Tripulante implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

    public String gender;
    
    public String url;
    
   
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

   
}
