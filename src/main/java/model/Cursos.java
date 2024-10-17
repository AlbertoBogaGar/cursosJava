package model;

import java.sql.Date;
import java.util.Objects;

public class Cursos {
	private int cod;
	private String curso;
	private Date fecha_ini;
	private Date fecha_fin;
	private String hora_ini;
	private String hora_fin;
	public Cursos(int cod, String curso, Date fecha_ini, Date fecha_fin, String hora_ini, String hora_fin) {
		this.cod = cod;
		this.curso = curso;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.hora_ini = hora_ini;
		this.hora_fin = hora_fin;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getHora_ini() {
		return hora_ini;
	}
	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod, curso, fecha_fin, fecha_ini, hora_fin, hora_ini);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cursos other = (Cursos) obj;
		return cod == other.cod && Objects.equals(curso, other.curso) && Objects.equals(fecha_fin, other.fecha_fin)
				&& Objects.equals(fecha_ini, other.fecha_ini) && Objects.equals(hora_fin, other.hora_fin)
				&& Objects.equals(hora_ini, other.hora_ini);
	}
	@Override
	public String toString() {
		return "Cursos cod=" + cod + ", curso=" + curso + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin
				+ ", hora_ini=" + hora_ini + ", hora_fin=" + hora_fin + "\n";
	}
	
	
}
