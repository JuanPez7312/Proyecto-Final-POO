package persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logica.Usuario;

public class Guardar {
	public static void ser(ArrayList<Usuario> usuarios) {
	    try {
	        File file = new File("archivos/datos.txt");
	        FileOutputStream fileOut = new FileOutputStream(file);
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(usuarios);
	        out.close();
	        fileOut.close();
	    } catch (IOException i) {
	    }
	}

}
