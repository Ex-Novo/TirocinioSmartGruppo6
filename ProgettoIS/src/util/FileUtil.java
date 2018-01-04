package util;

import java.io.File;

/**
 * Classe per gestire file system
 *
 */
public class FileUtil {
	
	/**
	 * Metodo che crea una cartella personale con l'id univoco dell'utente
	 * @author Mario Procida
	 */
	public void createFolder(String path,String filename) {
		
		
		
	    File f = new File (path + File.separator +  filename);
	    System.out.println(path + File.separator + filename);
	    if(!f.mkdir()) {
	    	System.out.println("errore creazione");
	    }
		
	}
}
