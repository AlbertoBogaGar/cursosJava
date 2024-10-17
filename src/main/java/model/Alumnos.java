package model;

import java.sql.Date;
import java.util.Objects;

public class Alumnos {
	private int cod;
	private String nombre;
	private String ape;
	private String tel;
	private Date fecha_nac;
	
	
	
	public Alumnos(int cod, String nombre, String ape, String tel, Date fecha_nac) {
		this.cod = cod;
		this.nombre = nombre;
		this.ape = ape;
		this.tel = tel;
		this.fecha_nac = fecha_nac;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ape, cod, fecha_nac, nombre, tel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnos other = (Alumnos) obj;
		return Objects.equals(ape, other.ape) && cod == other.cod && Objects.equals(fecha_nac, other.fecha_nac)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tel, other.tel);
	}
	@Override
	public String toString() {
		return "Alumnos [cod=" + cod + ", nombre=" + nombre + ", ape=" + ape + ", tel=" + tel + ", fecha_nac="
				+ fecha_nac + "\n";
	}
	
	
}
