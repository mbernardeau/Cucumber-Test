package com.insa;

import java.util.Date;

public class Classe {
	private String prof;
	private Date datedebut;
	private int duree;
	private String matiere; 
	
	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public Classe(String prof, Date datedebut, int duree, String matiere) {
		super();
		this.prof = prof;
		this.datedebut = datedebut;
		this.duree = duree;
		this.matiere = matiere;
	}


	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	
	
	
}
