package util;

import java.io.File;

public class FileManager {
	
	/**
	 * Metodo che crea una cartella personale con l'id univoco dell'utente
	 * @author Mario Procida
	 */
	public void createFolder(String path,String filename) {
		
		
		System.out.println(path);
	    File f = new File (path + "/" +  filename);
	    System.out.println(path + "/" + filename);
	    if(!f.mkdir()) {
	    	System.out.println("errore creazione");
	    }
		
	}
	
	public void uploadFile(String filename, String uniqueID) {
		
		
	}

}
