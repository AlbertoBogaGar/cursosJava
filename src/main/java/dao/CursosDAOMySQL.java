package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cursos;
import util.DBConnection;

public class CursosDAOMySQL implements CursosDAO{
	private final String SELECT_ALL="SELECT codigocurso,curso,fechainicio,fechafin,horainicio,horafin FROM cursos";

	@Override
	public List<Cursos> getAll() {
		System.out.println("Buscando todos los cursos...");
		List<Cursos> cursos=new ArrayList<Cursos>();
		Connection conn = DBConnection.getInstance().getConnection();
		if(conn!=null) {
			try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Cursos a = new Cursos(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6));
					cursos.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("Error al conectar con la bd");
		}

		return cursos;
	}

}
