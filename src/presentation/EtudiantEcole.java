package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import metier.Etudiant;

public class EtudiantEcole {
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// information de la base de donnee
		System.out.println("Pour insérer une école tapez 1");
		System.out.println("Pour insérer un étudiant tapez 2");
		System.out.println("Pour lister les écoles tapez 3");
		System.out.println("Pour lister les étudiants tapez 4");
		System.out.println("Pour supprimer une école tapez 5");
		System.out.println("Pour supprimer un étudiant tapez 6");
		System.out.println("Pour modifier le nom d'une école tapez 7");
		System.out.println("Pour modifier le nom d'un étudiant tapez 8");
		
		System.out.print("Saisir un chiffre");
		int saisie = scan.nextInt();
		
		switch (saisie) {
		case 1:
			// enrégistrer une école
			
			break;
		case 2:
			// enrégistrer un étudiant
			System.out.print("entrer le nom de l'etudiant : ");
			String nom = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'etudiant : ");
			String prenom = scan.next();
			Etudiant etudiant = new Etudiant( nom, prenom);
			creerEtudiant(etudiant);
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 7:
			System.out.print("entrer le nom de l'école à modifier: ");
			String ancienNom = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'école : ");
			String nouveauNom = scan.next();
			updateEtudiant(ancienNom, nouveauNom);
			break;
		case 8:
			System.out.print("entrer le nom de l'etudiant à modifier: ");
			String ancienNomEcole = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'etudiant : ");
			String nouveauNomEcole = scan.next();
			updateEtudiant(ancienNomEcole, nouveauNomEcole);
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
		
		
		

	}
	
	
	
public static void creerEtudiant(Etudiant etudiant) {
						
		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		try {
			// etape1 chargement du driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// etape2 recupertion de la connnexion
			
			cn = DriverManager.getConnection(url, login, password);
			
			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `etudiant` (`nom`,`prenom`) VALUES ('"+etudiant.getNomEtudiant()+"','"+etudiant.getPrenomEtudiant()+"')";
					
			//etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Enrégistrement effectué avec succès !!!! ");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	

























































































































// update de étudiant
public static void updateEtudiant(String ancienNom, String nouveauNom) {
	// information de la base de donnee

	String url = "jdbc:mysql://localhost/etudiantecole";
	String login = "root";
	String password = "";
	Connection cn = null;
	Statement st = null;

	try {
		// etape1 chargement du driver

		Class.forName("com.mysql.jdbc.Driver");

		// etape2 recupertion de la connnexion

		cn = DriverManager.getConnection(url, login, password);

		// etape 3 creation du statement
		st = cn.createStatement();
		String sql = "update etudiant set nom = '" + nouveauNom + "' where nom = '" + ancienNom+"'";

		// etape 4 executer la requette
		
		int rs = st.executeUpdate(sql);
		System.out.println("modification du nom de l'étudiant éffectuée avec succès");
		

	} catch (SQLException e) {
		System.out.println("Le nom n'existe pas");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} finally {

		// etape 5 liberer les ressources
		try {
			cn.close();
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
// update école
public static void updateEcole(String ancienNom, String nouveauNom) {
	// information de la base de donnee

	String url = "jdbc:mysql://localhost/etudiantecole";
	String login = "root";
	String password = "";
	Connection cn = null;
	Statement st = null;

	try {
		// etape1 chargement du driver

		Class.forName("com.mysql.jdbc.Driver");

		// etape2 recupertion de la connnexion

		cn = DriverManager.getConnection(url, login, password);

		// etape 3 creation du statement
		st = cn.createStatement();
		String sql = "update ecole set nomEcole = '" + nouveauNom + "' where nomEcole = '" + ancienNom+"'";

		// etape 4 executer la requette
		
		int rs = st.executeUpdate(sql);
		System.out.println("modification du nom de l'école éffectuée avec succès");
		

	} catch (SQLException e) {
		System.out.println("Le nom n'existe pas");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	} finally {

		// etape 5 liberer les ressources
		try {
			cn.close();
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
// delete étudiant





}
