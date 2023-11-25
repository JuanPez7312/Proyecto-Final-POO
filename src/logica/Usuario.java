package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private String username;
	private String clave;
	private Mascota mascota;
	private ArrayList<ListaTareas> listas;
	
	//Constructor vacio
	public Usuario(){
	}
	
	// Constructor con el nombre y contraseña
	public Usuario(String username, String clave) {
	
		this.username = username;
		this.clave = clave;
	}
	
	public static ArrayList<Usuario> getUs(){
		return usuarios;
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
