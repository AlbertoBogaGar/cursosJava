package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final String RUTA= "fichero";
	private String db_name;
	private String url;
	private String user;
	private String pass;
	private String driver;
	private Connection conn;
	// Singleton

	private static DBConnection instance;

	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;

	}

	private DBConnection() {
		leerFich();
		System.out.println("Conectando con la bd");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("Error al registrar el nuevo driver");
			e.printStackTrace();
		}
		try {
			String ruta = url + db_name;
			conn = DriverManager.getConnection(ruta, user, pass);
			System.out.println("Conexion con exito");
		} catch (SQLException e) {
			System.err.println("error al conectarcon la bd");
			e.printStackTrace();
		}
	}

	private void leerFich() {
		Path file=Paths.get(RUTA+"/rutas.txt");
		try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8);){
			String linea=null;
			while((linea=br.readLine()) != null) {
				parseo(linea);
			}
		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
			e.printStackTrace();
		}

	}

	private void parseo(String linea) {
		String[] keyval=linea.split("=");
		String key = keyval[0].trim();
		String val = keyval.length>1? keyval[1].trim():"";
		
		switch (key) {
		case "DBName":
			db_name=val;
			break;
		case "URL":
			url=val;
			break;
		case "USER":
			user=val;
			break;
		case "PASS":
			pass=val;
			break;
		case "Driver":
			driver=val;
			break;
		}
		
	}

	public Connection getConnection() {
		return conn;

	}

	public void destroyConnection() {
		System.out.println("Desconectanddo con la bd...");
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			System.out.println("Conexion cerrada con exito");
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexion");
			e.printStackTrace();
		}finally {
			instance=null;
		}
	}
}
