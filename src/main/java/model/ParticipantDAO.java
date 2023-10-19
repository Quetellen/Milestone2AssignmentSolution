package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ParticipantDAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/zumba?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Astro78*llOvw67%";

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/* CRUD CREATE */
	public void insertNewParticipant(Participant participant) {
		String create = "INSERT INTO participants (pname, phone, email, b_id) VALUES (?,?,?,?)";

		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, participant.getPname());
			pst.setString(2, participant.getPhone());
			pst.setString(3, participant.getEmail());
			pst.setString(4, participant.getB_id());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD READ */
	public ArrayList<Participant> listOfParticipants() {
		
		ArrayList<Participant> participants = new ArrayList<>();
		String read = "SELECT * FROM participants ORDER BY PNAME";

		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laco sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que receberm os dados do banco
				String p_id = rs.getString(1);
				String pname = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String b_id = rs.getString(5);
				// populando o Array list
				participants.add(new Participant(p_id, pname, phone, email, b_id));

			}
			con.close();
			return participants;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}
	
	/*CRUD UPDATE*/
	
	public void selectParticipants(Participant participant) {
		String read2 = "SELECT * FROM participants WHERE p_id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, participant.getP_id());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variaveis bacth
				participant.setP_id(rs.getString(1));
				participant.setPname(rs.getString(2));
				participant.setPhone(rs.getString(3));
				participant.setEmail(rs.getString(4));
				participant.setB_id(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateParticipants(Participant participant) {
		String create = "UPDATE participants SET pname=?, phone=?,email=?, b_id=? WHERE p_id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, participant.getPname());
			pst.setString(2, participant.getPhone());
			pst.setString(3, participant.getEmail());
			pst.setString(4, participant.getB_id());
			pst.setString(5, participant.getP_id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*CRUD DELETE*/
	
	public void deleteParticipant(Participant participant) {
		String delete = "DELETE FROM participants WHERE p_id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, participant.getP_id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
