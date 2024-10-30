package com.example.ingles.dto;

import lombok.Data;

@Data
public class VervosDTO {

	private String verboEnEspanol;
	private String infinitivo;
	private String pasadoSimple;
	private String participio;
	
	public String getVerboEnEspanol() {
		return verboEnEspanol;
	}
	public void setVerboEnEspanol(String vervoEnEspanol) {
		this.verboEnEspanol = vervoEnEspanol;
	}
	public String getInfinitivo() {
		return infinitivo;
	}
	public void setInfinitivo(String infinitivo) {
		this.infinitivo = infinitivo;
	}
	public String getPasadoSimple() {
		return pasadoSimple;
	}
	public void setPasadoSimple(String pasadoSimple) {
		this.pasadoSimple = pasadoSimple;
	}
	public String getParticipio() {
		return participio;
	}
	public void setParticipio(String participio) {
		this.participio = participio;
	}
	
	
	
	

}
