package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Ecole;
import metier.Etudiant;

public class EtudiantEcole {

	public static String password = "";

	public static void creerEcole(Ecole ecole) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

		Connection cn = null;
		Statement st = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `ecole` (`nomEcole`,`adresseEcole`) VALUES ('" + ecole.getNomEcole() + "','"
					+ ecole.getAdresseEcole() + "')";

			// etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Enrégistrement effectué avec succès !!!! ");

		} catch (SQLException e) {

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

	public static void lireEcole() {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

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

			// etape 4 executer la requette
			System.out.println("Liste des ecoles ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				System.out.print(rs.getString("nomEcole"));
				System.out.print(" ");
				System.out.println(rs.getString("adresseEcole"));
			}

		} catch (SQLException e) {

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

	public static void creerEtudiant(Etudiant etudiant, String nomEcole) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

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
			String sql = "select idEcole from ecole where nomEcole='" + nomEcole + "'";

			rs = st.executeQuery(sql);
			int idEcole = 0;
			while (rs.next()) {
				idEcole = rs.getInt(1);

			}

			String sql1 = "INSERT INTO `etudiant` (`nom`,`prenom`,`idEcole`) VALUES ('" + etudiant.getNomEtudiant()
					+ "','" + etudiant.getPrenomEtudiant() + "','" + idEcole + "')";

			// etape 4 executer la requette
			st.executeUpdate(sql1);
			System.out.println("Enrégistrement effectué avec succès !!!! ");

		} catch (SQLException e) {

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

	public static void lireEtudiant() {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

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

			// etape 4 executer la requette
			System.out.println("Liste des etudiants ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				System.out.println(rs.getInt("idEcole"));
				System.out.println(" ");
				System.out.print(rs.getString("nom"));
				System.out.print(" ");
				System.out.println(rs.getString("prenom"));

			}

		} catch (SQLException e) {

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

	public static void deleteEtudiant(String nom) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

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
			String sql = "delete from `etudiant` where `nom` = '" + nom + "'";
			// etape 4 executer la requette
			st.executeUpdate(sql);

			// etape5 parcours du resultSet
			System.out.println("Suppression éffectuée avec succès");

		} catch (SQLException e) {

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

//update de étudiant
	public static void updateEtudiant(String ancienNom, String nouveauNom) {
		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

		Connection cn = null;
		Statement st = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "update etudiant set nom = '" + nouveauNom + "' where nom = '" + ancienNom + "'";

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

//update école
	public static void updateEcole(String ancienNom, String nouveauNom) {
		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		Connection cn = null;
		Statement st = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "update ecole set nomEcole = '" + nouveauNom + "' where nomEcole = '" + ancienNom + "'";

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

	public static void deleteEcole(String nom) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null, rs2 = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sqlVerification = "SELECT distinct `idEcole` FROM `etudiant` WHERE `idEcole` = (SELECT `idEcole` FROM `ecole` WHERE `nomEcole` = '"
					+ nom + "')";
			rs2 = st.executeQuery(sqlVerification);
			if (rs2.next()) {
				System.out.println("Suppression impossible. L'école est reliée à des étudiants");
			} else {

				String sql = "delete from `ecole` where `nomEcole` = '" + nom + "'";
				// etape 4 executer la requette
				st.executeUpdate(sql);

				// etape5 parcours du resultSet
				System.out.println("Suppression éffectuée avec succès");
			}
		} catch (SQLException e) {

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
}
