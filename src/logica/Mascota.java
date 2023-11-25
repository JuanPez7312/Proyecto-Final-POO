package logica;

import java.io.Serializable;

public class Mascota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int nivel;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
}
