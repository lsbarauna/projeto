package br.com.imperiogalatico.trafegoespacial.service.client;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.imperiogalatico.trafegoespacial.model.Models;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

public class SwapiClient {

	
	public List<Planeta> listarPlaneta() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("User-Agent", "JAVA-APPLICATION");

		RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Models<Planeta>> res = restTemplate.exchange(
        		"http://swapi.co/api/planets/",
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Models<Planeta>>() {});

		return res.getBody().results;

	}

	public List<Tripulante> listarTripulante() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("User-Agent", "JAVA-APPLICATION");

		RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Models<Tripulante>> res = restTemplate.exchange(
        		"http://swapi.co/api/people/",
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Models<Tripulante>>() {});

		return res.getBody().results;

	}

	public List<Nave> listarNave() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("User-Agent", "JAVA-APPLICATION");

		RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Models<Nave>> res = restTemplate.exchange(
        		"http://swapi.co/api/starships/",
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Models<Nave>>() {});

		return res.getBody().results;
	}

}
