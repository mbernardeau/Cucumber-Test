package com.insa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.insa.Classe;
import com.insa.EmploiDuTemps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClasseSearchStep {
	EmploiDuTemps edt = new EmploiDuTemps();
	List<Classe> result = new ArrayList<>();
	List<String> resultMatiere = new ArrayList<>();
	
	
	@SuppressWarnings("deprecation")
	@Given(".+cours de '(.+)' dispensé par '(.+)' qui démarre à (\\d+)[h:](\\d+) le (\\d+) (\\d+) (\\d+) et qui dure (\\d+) minutes")
	public void addNewClasse(final String matiere, final String prof, final int heure, final int minutes, final int jour, final int mois, final int annee, final int duree) {
		edt.add(new Classe(prof, new Date(annee-1900, mois-1, jour, heure, minutes), duree, matiere));
	}
	
	@When("on cherche les cours dispensés le (\\d+) (\\d+) (\\d+)$")
	public void setSearchParameters(final int jour, final int mois, final int annee) {
		result = edt.trouverClassesDuJour(annee, mois, jour);
	}
	
	@When("on cherche les matières dispensées")
	public void setSearchMatieresParameters() {
		resultMatiere = edt.trouverMatieres();
	}
	
	@Then("on doit trouver (\\d+) cours")
	public void verifyAmountOfClassesFound(final int classesFound) {
		assertThat(result.size(), equalTo(classesFound));
	}
	
	@Then("on doit trouver (\\d+) matière[s?]")
	public void verifyAmountOfMatieresFound(final int classesFound) {
		assertThat(resultMatiere.size(), equalTo(classesFound));
	}
	
	@Then(".*le cours (\\d+) doit avoir pour matière '(.+)'")
	public void verifyClassesFound(final int noCours, final String matiere) {
		assertThat(result.get(noCours-1).getMatiere(), equalTo(matiere));
	}
	
	@Then(".*la matière (\\d+) doit avoir pour nom '(.+)'")
	public void verifyMatieres(final int noMatiere, final String matiere) {
		assertThat(resultMatiere.get(noMatiere-1), equalTo(matiere));
	}
	
	
}
