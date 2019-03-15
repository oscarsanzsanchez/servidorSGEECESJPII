package sgeecesjpii.servidor.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Alumnos")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idalumno")
	private Integer idAlumno;
	private String ciclo;
	private String curso;
	private String nombre;
	private String apellidos;
	private String email;
	
	@Column(name = "entradasgratuitas")
	private Integer numEntradasGratuitas;
	
	@Column(name = "Eventos_idEvento")
	private Integer idEvento;

	
	public Alumno() {
	}

	/**
	 * @return the idAlumno
	 */
	public Integer getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	/**
	 * @return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the numEntradasGratuitas
	 */
	public Integer getNumEntradasGratuitas() {
		return numEntradasGratuitas;
	}

	/**
	 * @param numEntradasGratuitas the numEntradasGratuitas to set
	 */
	public void setNumEntradasGratuitas(Integer numEntradasGratuitas) {
		this.numEntradasGratuitas = numEntradasGratuitas;
	}

	/**
	 * @return the idEvento
	 */
	public Integer getIdEvento() {
		return idEvento;
	}

	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

}
