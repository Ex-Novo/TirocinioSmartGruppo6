package util;

import java.io.File;

public class FileManager {
	
	/**
	 * Metodo che crea una cartella personale con l'id univoco dell'utente
	 * @param path
	 * @param id
	 * @author Mario Procida
	 */
	public void createFolder(String path, String id) {
		
		File f = new File (path + id);
		if(!f.mkdir()) {
			System.out.println("Cartella non creata");
		};
	}

}
