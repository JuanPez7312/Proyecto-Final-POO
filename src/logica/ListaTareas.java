package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaTareas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Tareas> tareas;
	private String titulo;
	
	public ArrayList<Tareas> getTareas() {
		return tareas;
	}
	public void setTareas(ArrayList<Tareas> tareas) {
		this.tareas = tareas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
