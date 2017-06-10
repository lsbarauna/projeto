package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Models<T> implements Serializable {
	
   
	private static final long serialVersionUID = 1L;
	public Integer count;
    public String next;
    public String previous;
    public ArrayList<T> results;

   
}
