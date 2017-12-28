package bean;

import java.util.Date;

public class RichiestaTirocinio {
	
	private int idRichiestaTirocinio;
	private String nomeTutorAccademico;
	private String status;
	private Date data;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
