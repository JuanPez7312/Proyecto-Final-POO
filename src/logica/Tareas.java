package logica;

import java.util.ArrayList;

public class Tareas {
	private int id;
	private String titulo;
	private String subtitulo;
	private Tiempo tiempo;
	private Object descript;
	private int prioridad;
	private ArrayList<Subtareas> subtareas;
	private int estado;
	
	public Tareas() {
		this.tiempo = new Tiempo();
	}
	
	//Getters and Setters

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Object getDescript() {
		return descript;
	}

	public void setDescript(Object descript) {
		this.descript = descript;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public ArrayList<Subtareas> getSubtareas() {
		return subtareas;
	}
	
	
}
