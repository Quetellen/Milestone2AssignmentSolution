package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/* Creating CRUD operations*/

public class BatchDAO {
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
	public void insertNewBatch(Batch batch) {
		String create = "INSERT INTO batch(name, startTime, endTime, shift) VALUES (?,?,?,?)";
		try {

			Connection con = connect();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, batch.getName());
			pst.setString(2, batch.getStartTime());
			pst.setString(3, batch.getEndTime());
			pst.setString(4, batch.getShift());

			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * CRUD READ
	 */
	public ArrayList<Batch> listbatches() {

		ArrayList<Batch> batch = new ArrayList<>();
		String read = "SELECT * FROM batch ORDER BY NAME";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String b_id = rs.getString(1);
				String name = rs.getString(2);
				String startTime = rs.getString(3);
				String endTime = rs.getString(4);
				String shift = rs.getString(5);

				batch.add(new Batch(b_id, name, startTime, endTime, shift));

			}
			con.close();
			return batch;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/*
	 * CRUD UPDATE
	 */

	public void selectBatch(Batch batch) {
		String read2 = "SELECT * FROM batch WHERE b_id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, batch.getB_id());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				batch.setB_id(rs.getString(1));
				batch.setName(rs.getString(2));
				batch.setStartTime(rs.getString(3));
				batch.setEndTime(rs.getString(4));
				batch.setShift(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateBatch(Batch batch) {
		String create = "UPDATE batch SET name=?, startTime=?,endTime=?,shift=? WHERE b_id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, batch.getName());
			pst.setString(2, batch.getStartTime());
			pst.setString(3, batch.getEndTime());
			pst.setString(4, batch.getShift());
			pst.setString(5, batch.getB_id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD DELETE */
	public void deleteBatch(Batch batch) {
		String delete = "DELETE FROM batch WHERE b_id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, batch.getB_id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
