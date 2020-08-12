package idat.edu.pe.cautela.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="domicilio")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
    , @NamedQuery(name = "Domicilio.findByIdDomicilio", query = "SELECT d FROM Domicilio d WHERE d.idDomicilio = :idDomicilio")
    , @NamedQuery(name = "Domicilio.findByDireccion", query = "SELECT d FROM Domicilio d WHERE d.direccion = :direccion")
     , @NamedQuery(name = "Domicilio.findByDepartamento", query = "SELECT d FROM Domicilio d WHERE d.departamento = :departamento")
     , @NamedQuery(name = "Domicilio.findByProvincia", query = "SELECT d FROM Domicilio d WHERE d.provincia = :provincia")
     , @NamedQuery(name = "Domicilio.findByDistrito", query = "SELECT d FROM Domicilio d WHERE d.distrito = :distrito")})

public class Domicilio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idDomicilio")
	private Integer idDomicilio;
	
	@JoinColumn(name="fk_idUsuarioDomicilio", referencedColumnName = "idUsuario")
	@ManyToOne
	private Usuario fk_idUsuarioDomicilio;
	
	@Basic(optional = false)
	@Column(name="direccion")
	private String direccion;
	
	@Basic(optional = false)
	@Column(name="departamento")
	private String departamento;
	
	@Basic(optional = false)
	@Column(name="provincia")
	private String provincia;
	
	@Basic(optional = false)
	@Column(name="distrito")
	private String distrito;
	
	
	
	
	
	public Domicilio() {
		// TODO Auto-generated constructor stub
	}

	public Domicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public Domicilio(Integer idDomicilio, String direccion, String departamento, String provincia, String distrito) {
		this.idDomicilio = idDomicilio;
		this.direccion = direccion;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
	}

	public Integer getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	

	 @XmlTransient
	 
	 public Usuario getFk_idUsuarioDomicilio() {
			return fk_idUsuarioDomicilio;
		}

		public void setFk_idUsuarioDomicilio(Usuario fk_idUsuarioDomicilio) {
			this.fk_idUsuarioDomicilio = fk_idUsuarioDomicilio;
		}
	 

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Domicilio)) {
	            return false;
	        }
	        Domicilio other = (Domicilio) object;
	        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	    	 return "javaapplication1.Domicilio[ idDomicilio=" + idDomicilio + " ]";
	    }

	

}
