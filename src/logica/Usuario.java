package logica;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	private String id;
	private String username;
	private String clave;
	private Mascota mascota;
	private ArrayList<ListaTareas> listas;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public ArrayList<ListaTareas> getListas() {
		return listas;
	}
	public void setListas(ArrayList<ListaTareas> listas) {
		this.listas = listas;
	}
	
	
}
