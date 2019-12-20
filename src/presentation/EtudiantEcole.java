package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import metier.Etudiant;

public class EtudiantEcole {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("entrer le nom de l'etudiant : ");
		String nom = scan.next();
		System.out.println();
		System.out.print("entrer le prenom de l'etudiant : ");
		String prenom = scan.next();
		Etudiant etudiant = new Etudiant( nom, prenom);
		creerEtudiant(etudiant);
		

	}
	
	
	
public static void creerEtudiant(Etudiant etudiant) {
		
		// information de la base de donnee
		
		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		String password = "Passer@18";
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
	
	

}
