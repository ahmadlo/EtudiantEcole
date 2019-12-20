package metier;

import java.util.ArrayList;
import java.util.List;

public class Ecole {

	
	private String nomEcole;
	private String adresseEcole;
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	
	public Ecole(String nomEcole, String adresseEcole) {
		super();
		this.nomEcole = nomEcole;
		this.adresseEcole = adresseEcole;
	}

	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public String getAdresseEcole() {
		return adresseEcole;
	}

	public void setAdresseEcole(String adresseEcole) {
		this.adresseEcole = adresseEcole;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Ecole [nomEcole=" + nomEcole + ", adresseEcole=" + adresseEcole + "]";
	}
		
}
