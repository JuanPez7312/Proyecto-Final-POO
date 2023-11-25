package logica;

import java.util.ArrayList;

public class ListaTareas {
	private int id;
	private ArrayList<Tareas> tareas;
	private String titulo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
