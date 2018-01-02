package dao;

import java.util.ArrayList;

import bean.Convenzione;
import bean.RichiestaTirocinio;

public interface RichiesteDaoInterface {

	/** Crea una richiesta di tirocinio e la salva nel database tramite una query
	 * 
	 * @return un booleano: "true" se è andata a buon fine, altrimenti "false"
	 */
	
	public boolean invioRichiestaTirocinio(String tutorAziendale);
	
	/** Crea una richiesta di convenzione e la salva nel database tramite una query
	 * 
	 * @return	un booleano: "true" se è andata a buon fine, altrimenti "false"
	 */
	
	public boolean invioRichiestaConvenzione();
	
	
	
	/* Dettaglio convenzione nella convenzione diverrà la descrizione del tirocinio */
	/* 
	 * Creare un if nel control per vedere che tipo di tasto è stato premuto
	 * Ex:	1 step: per entrambi i control per confermare il form e salvare i dati nei bean
	 * 				nel DB tramite i DAO;
	 * 				forward alla pagina per fare upload o confermare;
	 * 
	 * 		2 step: se vuole confermare dati 1 step -> salvi tramite i metodi DAO nel database; 
	 * 				se vuole fare upload -> 
	 * 		  
	 */
	
	
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);

	public boolean approvazioneRichiestaConvenzione(Convenzione convenzione);
	
	
	
	/**
	 * 
	 * Effettua una query nel database per cercare tutte le richieste di tirocinio
	 * @return ritorna la lista delle richieste di tirocinio
	 */
	
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio();
	
	/**
	 * 
	 * Effettua una query nel database per cercare tutte le richieste di convenzione
	 * @return ritorna la lista delle richieste di convenzione
	 */
	
	public ArrayList<Convenzione> getRichiesteConvenzione();
}
