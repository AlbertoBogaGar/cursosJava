package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Evaluaciones;
import util.DBConnection;

public class EvaluacionesDAOMySQL implements EvaluacionesDAO {
	private final String SELECT_ALL = "SELECT a.nombre,a.apellidos,c.curso,e.notafinal,e.observaciones FROM alumnos a JOIN evaluaciones e USING(codigoalumno) JOIN cursos c USING(codigocurso)";

	private final String SELECT_BY_COD = "SELECT a.nombre,a.apellidos,c.curso,e.notafinal,e.observaciones FROM alumnos a JOIN evaluaciones e USING(codigoalumno) JOIN cursos c USING(codigocurso) WHERE codigoalumno=?";

	@Override
	public List<Evaluaciones> getAll() {
		System.out.println("Buscando todos los alumnos...");
		List<Evaluaciones> alu = new ArrayList<Evaluaciones>();
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn != null) {
			try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Evaluaciones a = new Evaluaciones(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getString(5));
					alu.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.println("Error al conectar con la bd");
		}

		return alu;
	}

	@Override
	public List<Evaluaciones> getByCod(int cod) {
		System.out.println("Buscando alumno con codigo: "+ cod);
		List<Evaluaciones> alu = new ArrayList<Evaluaciones>();
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn != null) {
			try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_COD);) {
				stmt.setInt(1, cod);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Evaluaciones a = new Evaluaciones(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getString(5));
					alu.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.println("Error al conectar con la bd");
		}

		return alu;
	}

}
