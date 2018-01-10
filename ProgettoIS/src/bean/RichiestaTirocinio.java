package bean;
/**
 * Bean dell'entità RichiestaTirocinio
 * @author Anna Maria Rosanova
 *
 */
public class RichiestaTirocinio {
	
	private int idRichiestaTirocinio;
	private String nomeTutorAccademico;
	private String status;
	private String data;
	
	private String emailTutAcc; // campi per chiavi esterne
	private String emailDir;
	private String matricola;
	private String nomeFile;
	
	
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	private int idTirocinio;
	
	
	public int getIdRichiestaTirocinio() {
		return idRichiestaTirocinio;
	}
	public void setIdRichiestaTirocinio(int idRichiestaTirocinio) {
		this.idRichiestaTirocinio = idRichiestaTirocinio;
	}
	public String getNomeTutorAccademico() {
		return nomeTutorAccademico;
	}
	public void setNomeTutorAccademico(String nomeTutorAccademico) {
		this.nomeTutorAccademico = nomeTutorAccademico;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEmailTutAcc() {
		return emailTutAcc;
	}
	public void setEmailTutAcc(String emailTutAcc) {
		this.emailTutAcc = emailTutAcc;
	}
	public String getEmailDir() {
		return emailDir;
	}
	public void setEmailDir(String emailDir) {
		this.emailDir = emailDir;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public int getIdTirocinio() {
		return idTirocinio;
	}
	public void setIdTirocinio(int idTirocinio) {
		this.idTirocinio = idTirocinio;
	}
}
