package idat.edu.pe.cautela.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="orden")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Domicilio.findByMetodoPagoOrden", query = "SELECT o FROM Orden o WHERE o.metodoPagoOrden = :metodoPagoOrden")
     , @NamedQuery(name = "Domicilio.findByTotal", query = "SELECT o FROM Orden o WHERE o.total = :total")})
public class Orden implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name="idOrden")
	private Integer idOrden;
	
	@JoinColumn(name="fk_idUsuarioOrden", referencedColumnName = "idUsuario")
	@ManyToOne
	private Usuario fk_idUsuarioOrden;
	
    @Basic(optional = false)
	@Column(name="metodoPagoOrden")
	private String metodoPagoOrden;
	
    @Basic(optional = false)
	@Column(name="total")
	private Double total;
	
    @Basic(optional = false)
	@Column(name="idDomicilio")
	private Integer idDomicilio;
	

	public Orden() {
		
	}

	public Orden(Integer idOrden) {
		this.idOrden = idOrden;
	}



	public Orden(Integer idOrden, String metodoPagoOrden, Double total, Integer idDomicilio) {
		this.idOrden = idOrden;
		this.metodoPagoOrden = metodoPagoOrden;
		this.total = total;
		this.idDomicilio = idDomicilio;
	}

	
	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public String getMetodoPagoOrden() {
		return metodoPagoOrden;
	}

	public void setMetodoPagoOrden(String metodoPagoOrden) {
		this.metodoPagoOrden = metodoPagoOrden;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public Orden(Usuario fk_idUsuarioOrden) {
		this.fk_idUsuarioOrden = fk_idUsuarioOrden;
	}
	

	public Usuario getFk_idUsuarioOrden() {
		return fk_idUsuarioOrden;
	}

	public void setFk_idUsuarioOrden(Usuario fk_idUsuarioOrden) {
		this.fk_idUsuarioOrden = fk_idUsuarioOrden;
	}

	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idOrden != null ? idOrden.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Orden)) {
	            return false;
	        }
	        Orden other = (Orden) object;
	        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
	            return false;
	        }
	        return true;
	    }
	    
	@Override
	public String toString() {
		 return "javaapplication1.Domicilio[ idOrden=" + idOrden + " ]";
	}
	
	
	
	
	
	
}
