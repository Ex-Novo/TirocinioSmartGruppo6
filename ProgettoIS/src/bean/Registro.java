package bean;

/**
 * Bean dell'entità Registro
 * @author Anna Maria Rosanova
 *
 */
public class Registro {
	private int idRegistro;
	private String matricola;
	private String p_iva;
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	
}
