package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import model.Alumnos;
import repository.AlumnoRepository;

public class AlumnoService {
//SELECT ALL
	public List<Alumnos> getAll(){
		return AlumnoRepository.getInstance().getAll();
	}
//INSERT
	public boolean insert(Alumnos alumnos){
		return AlumnoRepository.getInstance().insert(alumnos);
	}
//UPDATE
	public boolean update(Alumnos alumnos){
		return AlumnoRepository.getInstance().update(alumnos);
	}
//DELETE
	public boolean delete(int cod){
		return AlumnoRepository.getInstance().delete(cod);
	}
	
	public void escribirAlumnos() {
		List<Alumnos> lista = getAll();
		String file = "fichero";
		Path esc=Paths.get(file+ "/volcado.txt");
		try (BufferedWriter bw= Files.newBufferedWriter(esc, StandardCharsets.UTF_8);){
			for (Alumnos alumnos : lista) {
				String cityLine = alumnos.toString();
				bw.write(cityLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (BufferedReader br = Files.newBufferedReader(esc, StandardCharsets.UTF_8);){
			String linea = null;
			while((linea=br.readLine()) != null) {
				System.out.println(linea);
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
