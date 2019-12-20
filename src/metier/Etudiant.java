package metier;

public class Etudiant {

	
	private String numEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private Ecole ecole;
		
	public Etudiant(String numE, String nomE, String prenomE) {
		this.numEtudiant = numE;
		this.nomEtudiant = nomE;
		this.prenomEtudiant = prenomE;
	}
	
	public String getNumEtudiant() {
		return numEtudiant;
	}
	public void setNumEtudiant(String numE) {
		this.numEtudiant = numE;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomE) {
		this.nomEtudiant = nomE;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomE) {
		this.prenomEtudiant = prenomE;
	}
	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	public String faireExamen() {
		return nomEtudiant + " a fait un examen" ;
	}
	
	public boolean inscrire() {
		if (this.getEcole() == null) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Etudiant [numEtudiant=" + numEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant=" + prenomEtudiant + "]";
	}	
}
