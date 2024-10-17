package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumnos;
import util.DBConnection;

public class AlumnoDAOMySQL implements AlumnoDAO {
	private final String SELECT_ALL="SELECT codigoalumno,nombre,apellidos,telefono,fechanacimiento FROM alumnos";
	private final String INSERT="INSERT INTO alumnos (codigoalumno,nombre,apellidos,telefono,fechanacimiento) VALUES (?,?,?,?,?) ";
	private final String UPDATE="UPDATE alumnos SET  nombre=?,apellidos=?,telefono=?,fechanacimiento=? WHERE codigoalumno=?";
	private final String DELETE="DELETE FROM alumnos WHERE codigoalumno=?";
	@Override
	public List<Alumnos> getAll() {
		System.out.println("Buscando todos los alumnos...");
		List<Alumnos> alu=new ArrayList<Alumnos>();
		Connection conn = DBConnection.getInstance().getConnection();
		if(conn!=null) {
			try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Alumnos a = new Alumnos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
					alu.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("Error al conectar con la bd");
		}

		return alu;
	}
	@Override
	public boolean insert(Alumnos alumnos) {
		System.out.println("Insertando alumno...");
		boolean in = false;
		Connection conn = DBConnection.getInstance().getConnection();
		if(conn!=null) {
			try (PreparedStatement stmt = conn.prepareStatement(INSERT);){
				stmt.setInt(1, alumnos.getCod());
				stmt.setString(2, alumnos.getNombre());
				stmt.setString(3, alumnos.getApe());
				stmt.setString(4, alumnos.getTel());
				stmt.setDate(5, alumnos.getFecha_nac());
				int affected = stmt.executeUpdate();
				if(affected==1) {
					in=true;
					System.out.println("Insertado con exito");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("Error al conectar con la bd");
		}

		return in;
	}
	@Override
	public boolean update(Alumnos alumnos) {
		System.out.println("Actualizando alumno...");
		boolean in = false;
		Connection conn = DBConnection.getInstance().getConnection();
		if(conn!=null) {
			try (PreparedStatement stmt = conn.prepareStatement(UPDATE);){
				stmt.setInt(5, alumnos.getCod());
				stmt.setString(1, alumnos.getNombre());
				stmt.setString(2, alumnos.getApe());
				stmt.setString(3, alumnos.getTel());
				stmt.setDate(4, alumnos.getFecha_nac());
				int affected = stmt.executeUpdate();
				if(affected==1) {
					in=true;
					System.out.println("Actualizado con exito");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("Error al conectar con la bd");
		}

		return in;
	}
	@Override
	public boolean delete(int cod) {
		System.out.println("Borrando alumno...");
		boolean in = false;
		Connection conn = DBConnection.getInstance().getConnection();
		if(conn!=null) {
			try (PreparedStatement stmt = conn.prepareStatement(DELETE);){
				stmt.setInt(1, cod);
				
				int affected = stmt.executeUpdate();
				if(affected==1) {
					in=true;
					System.out.println("Borrado con exito");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("Error al conectar con la bd");
		}

		return in;
	}

}
