package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import metier.Ecole;
import metier.Etudiant;

public class EtudiantEcole {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	
		//
		/*System.out.print("entrer le nom de l'ecole : ");
		String nomEcole = scan.next();
		System.out.print("entrer le adresse de l'cole : ");
		String adresseEcole = scan.next();
		System.out.println();
		Ecole ecole =new Ecole(nomEcole, adresseEcole);
		creerEcole(ecole);
		lireEcole();*/
		/*System.out.print("entrer le nom de l'etudiant : ");
		String nom = scan.next();
		System.out.println();
		System.out.print("entrer le prenom de l'etudiant : ");
		String prenom = scan.next();
		System.out.print("entrer l'ecole l'etudiant : ");
		String ecoleEtudiant = scan.next();
		Etudiant etudiant = new Etudiant( nom, prenom);
		creerEtudiant(etudiant,ecoleEtudiant);*/
		lireEtudiant();
		
		System.out.print("entrer le nom de l'etudiant a supprimer : ");
		String etudiantSupprime = scan.next();
		deleteEtudiant(etudiantSupprime);
	}
	
	
public static void creerEcole(Ecole ecole) {
		
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
			String sql = "INSERT INTO `ecole` (`nomEcole`,`adresseEcole`) VALUES ('"+ecole.getNomEcole()+"','"+ecole.getAdresseEcole()+"')";
					
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
public static void lireEcole() {
	
	// information de la base de donnee
	
			String url = "jdbc:mysql://localhost/etudiantecole";
			String login = "root";
			String password = "Passer@18";
			Connection cn = null;
			Statement st = null;
			ResultSet rs = null;
			
			try {
				// etape1 chargement du driver
				
				Class.forName("com.mysql.jdbc.Driver");
				
				// etape2 recupertion de la connnexion
				
				cn = DriverManager.getConnection(url, login, password);
				
				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from ecole";
				
				//etape 4 executer la requette
				System.out.println("Liste des ecoles ");
				rs = st.executeQuery(sql);		
				
				//etape5 parcours du resultSet
				while (rs.next()) {
					System.out.print(rs.getString("nomEcole"));
					System.out.print(" ");
					System.out.println(rs.getString("adresseEcole"));
				}
			
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
	
public static void creerEtudiant(Etudiant etudiant, String nomEcole) {
		
		// information de la base de donnee
		
		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		String password = "Passer@18";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// etape1 chargement du driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// etape2 recupertion de la connnexion
			
			cn = DriverManager.getConnection(url, login, password);
			
			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select idecole from ecole where nomEcole='"+nomEcole+"'";
			
			rs = st.executeQuery(sql);	
			int idecole=0;
			while(rs.next()) {
			 idecole = rs.getInt(1);

			}

			
			String sql1 = "INSERT INTO `etudiant` (`nom`,`prenom`,`idecole`) VALUES ('"+etudiant.getNomEtudiant()+"','"+etudiant.getPrenomEtudiant()+"','"+idecole+"')";
					
			//etape 4 executer la requette
			st.executeUpdate(sql1);
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
	
public static void lireEtudiant() {
	
	// information de la base de donnee
	
			String url = "jdbc:mysql://localhost/etudiantecole";
			String login = "root";
			String password = "Passer@18";
			Connection cn = null;
			Statement st = null;
			ResultSet rs = null;
			
			try {
				// etape1 chargement du driver
				
				Class.forName("com.mysql.jdbc.Driver");
				
				// etape2 recupertion de la connnexion
				
				cn = DriverManager.getConnection(url, login, password);
				
				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from etudiant";
				
				//etape 4 executer la requette
				System.out.println("Liste des etudiants ");
				rs = st.executeQuery(sql);		
				
				//etape5 parcours du resultSet
				while (rs.next()) {
					System.out.print(rs.getString("nom"));
					System.out.print(" ");
					System.out.println(rs.getString("prenom"));
					System.out.println(rs.getInt("idecole"));
				}
			
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

public static void deleteEtudiant(String nom) {
	
	// information de la base de donnee
	
			String url = "jdbc:mysql://localhost/etudiantecole";
			String login = "root";
			String password = "Passer@18";
			Connection cn = null;
			Statement st = null;
			ResultSet rs = null;
			
			try {
				// etape1 chargement du driver
				
				Class.forName("com.mysql.jdbc.Driver");
				
				// etape2 recupertion de la connnexion
				
				cn = DriverManager.getConnection(url, login, password);
				
				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "delete  from etudiant where nom = '"+ nom +"'";
				//etape 4 executer la requette
				rs = st.executeQuery(sql);		
				
				//etape5 parcours du resultSet
				while (rs.next()) {
					System.out.print(rs.getString("nom"));
					System.out.print(" ");
					System.out.println(rs.getString("prenom"));
					System.out.println(rs.getInt("idecole"));
				}
			
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
