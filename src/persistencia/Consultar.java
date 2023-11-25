package persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import logica.Usuario;

public class Consultar {
	@SuppressWarnings("unchecked")
	public static ArrayList<Usuario> deserializar() {
		// Deserializar la lista de objetos
		ArrayList<Usuario> es = new ArrayList<Usuario>();
		try {
			FileInputStream fileIn = new FileInputStream("archivos\\datos.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			es = (ArrayList<Usuario>) in.readObject();
			in.close();
			fileIn.close();
		} catch (ClassNotFoundException c) {
		} catch (IOException i) {
		}
		return es;
	}

}
