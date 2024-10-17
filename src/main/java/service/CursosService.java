package service;

import java.util.List;

import model.Alumnos;
import model.Cursos;
import repository.AlumnoRepository;
import repository.CursosRepository;

public class CursosService {
	//SELECT ALL
		public List<Cursos> getAll(){
			return CursosRepository.getInstance().getAll();
		}
}
