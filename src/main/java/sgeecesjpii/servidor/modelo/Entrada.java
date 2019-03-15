package sgeecesjpii.servidor.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Entradas")
public class Entrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty(value = "idEntrada")
	@Column(name = "identrada")
	private Integer idEntrada;

	@JsonProperty(value = "idAlumno")
	@Column(name = "idalumno")
	private Integer idAlumno;

	@JsonProperty(value = "numEntradasObtenidas")
	@Column(name = "numentradas")
	private Integer numEntradasObtenidas;

	@JsonProperty(value = "fechaVenta")
	@Column(name = "fechaventa")
	private Date fechaVenta;

	@JsonProperty(value = "idUsuario")
	@Column(name = "idusuario")
	private Integer idUsuario;

	@JsonProperty(value = "hash")
	private String hash;

	@Transient
	private Alumno alumno;

	public Entrada() {
	}

	/**
	 * @return the idEntrada
	 */
	public Integer getIdEntrada() {
		return idEntrada;
	}

	/**
	 * @param idEntrada the idEntrada to set
	 */
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
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
	 * @return the numEntradasObtenidas
	 */
	public Integer getNumEntradasObtenidas() {
		return numEntradasObtenidas;
	}

	/**
	 * @param numEntradasObtenidas the numEntradasObtenidas to set
	 */
	public void setNumEntradasObtenidas(Integer numEntradasObtenidas) {
		this.numEntradasObtenidas = numEntradasObtenidas;
	}

	/**
	 * @return the fechaVenta
	 */
	public Date getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta the fechaVenta to set
	 */
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	

}
