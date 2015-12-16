package com.insa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmploiDuTemps extends ArrayList<Classe> {
	
	public List<Classe> trouverClassesDuJour(int annee, int mois, int jour){
		Date from = new Date(annee-1900, mois-1, jour, 0,0);
		Date end = new Date(annee-1900, mois-1, jour, 23,59);
		
		return this.stream().filter(Classe -> {
			return from.before(Classe.getDatedebut()) && end.after(Classe.getDatedebut());
		}).sorted(Comparator.comparing(Classe::getDatedebut).reversed()).collect(Collectors.toList());
	}
	
	public List<String> trouverMatieres(){
		return this.stream().map(Classe::getMatiere).sorted().collect(Collectors.toList());
		
	}
}
