package presentation;

import java.util.Scanner;

import javax.management.openmbean.OpenMBeanOperationInfo;

import metier.Ecole;
import metier.Etudiant;

public class luncher {

	private static void afficher() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour insérer une école tapez 1");
		System.out.println("Pour insérer un étudiant tapez 2");
		System.out.println("Pour lister les écoles tapez 3");
		System.out.println("Pour lister les étudiants tapez 4");
		System.out.println("Pour supprimer une école tapez 5");
		System.out.println("Pour supprimer un étudiant tapez 6");
		System.out.println("Pour modifier le nom d'une école tapez 7");
		System.out.println("Pour modifier le nom d'un étudiant tapez 8");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	private static Integer saisieOperation() {
		// saisir une numéro qui correspond à une opération
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	// regroupement des méthodes qui se répètent
	private static void methodeARepetition() {
		// appel de la méthode afficher
		afficher();
		// récupération du chiffre saisie
		int saisie = saisieOperation();
		// opération à exécuter
		operation(saisie);
	}

	/*
	 * mot de passe base de donnée
	 */
	private static void saisirMotDePasse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Avez vous un mot de passe pour mysql O / N : ");
		String reponse = sc.next().toUpperCase();
		if (reponse.equals("O")) {
			System.out.println();
			System.out.print("Veuillez saisir le mot de passe de votre base mysql : ");
			System.out.println();
			EtudiantEcole.password = sc.next();
		}
	}

	// méthode main
	public static void main(String[] args) {
		// mot de passe mysql
		saisirMotDePasse();
		// opération à faire
		methodeARepetition();

	}

	/*
	 * demander si l'utilisateur veut poursuivre les opérations
	 */
	private static void continuerOperation() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Voulez-vous continuer? O / N : ");
		System.out.println();
		String reponse = sc.next().toUpperCase();
		//
		switch (reponse) {

		case "O":
			// recommencer
			methodeARepetition();
			break;
		case "N":
			// finir le programme
			System.out.println("Au revoir !!!");
			break;
		default:
			// reposer la question
			System.out.println("Mauvaise reponse");
			continuerOperation();
			break;
		}
	}

	/*
	 * opération à exécuter
	 */
	private static void operation(int chiffre) {
		Scanner scan = new Scanner(System.in);
		switch (chiffre) {
		case 1:
			// enrégistrer une école
			System.out.println();
			System.out.print("entrer le nom de l'école : ");
			String nomEcol = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'école : ");
			String adresse = scan.next();
			Ecole ecole = new Ecole(nomEcol, adresse);
			EtudiantEcole.creerEcole(ecole);
			continuerOperation();
			break;

		case 2:
			System.out.println();
			// enrégistrer un étudiant
			System.out.print("entrer le nom de l'etudiant : ");
			String nom = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'etudiant : ");
			String prenom = scan.next();
			System.out.println();
			System.out.print("entrer le nom de l'école : ");
			String nomEcole = scan.next();
			Etudiant etudiant = new Etudiant(nom, prenom);
			EtudiantEcole.creerEtudiant(etudiant, nomEcole);
			continuerOperation();
			break;

		case 3:
			// lister les écoles
			System.out.println();
			System.out.println("La liste des écoles");
			EtudiantEcole.lireEcole();
			continuerOperation();
			break;
		case 4:
			// lister les étudiants
			System.out.println();
			System.out.println("La liste des étudiants");
			EtudiantEcole.lireEtudiant();
			continuerOperation();
			break;
		case 5:
			// supprimer une école
			System.out.println();
			System.out.print("entrer le nom de l'école à supprimer: ");
			String nomEcoleSupprimer = scan.next();
			EtudiantEcole.deleteEcole(nomEcoleSupprimer);
			continuerOperation();
			break;

		case 6:
			// supprimer un étudiant
			System.out.println();
			System.out.print("entrer le nom de l'étudiant à supprimer: ");
			String nomEtudiantSupprimer = scan.next();
			EtudiantEcole.deleteEtudiant(nomEtudiantSupprimer);
			continuerOperation();
			break;

		case 7:
			// modifer une école
			System.out.println();
			System.out.print("entrer le nom de l'école à modifier: ");
			String ancienNomEcole = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'école : ");
			String nouveauNomEcole = scan.next();
			EtudiantEcole.updateEcole(ancienNomEcole, nouveauNomEcole);
			continuerOperation();
			break;
		case 8:
			// modifier un étudiant
			System.out.println();
			System.out.print("entrer le nom de l'etudiant à modifier: ");
			String ancienNom = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'etudiant : ");
			String nouveauNom = scan.next();
			EtudiantEcole.updateEtudiant(ancienNom, nouveauNom);
			continuerOperation();
			break;

		default:
			// si aucune opération ne correspond
			System.out.println();
			System.out.println("Vous avez saisi un mauvais chiffre. Veuillez reprendre Merci.");
			methodeARepetition();
			break;
		}

	}

}
