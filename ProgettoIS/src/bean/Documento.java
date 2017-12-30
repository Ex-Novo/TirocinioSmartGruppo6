package bean;


/**
 * Bean dell'entità Documento
 * @author Anna Maria Rosanova
 *
 */
public class Documento {

	private int idDocumento;
	private String tipo;
	private String path;
	
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
