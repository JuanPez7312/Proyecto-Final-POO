package logica;

import java.util.ArrayList;

import persistencia.Consultar;

public class Revisar {
	public static boolean revName(String usName) {
		ArrayList<Usuario> usuarios = Consultar.deserializar();
		for(Usuario us : usuarios) {
			if(us.getUsername().equals(usName))
				return true;
		}
		return false;
	}
	
	public static Usuario ingre(String clav, String usName) {
		ArrayList<Usuario> usuarios = Consultar.deserializar();
		for (Usuario us : usuarios) {
			if(us.getUsername().equals(usName) && us.getClave().equals(clav))
				return us;
		}
		return null;
	}
}
