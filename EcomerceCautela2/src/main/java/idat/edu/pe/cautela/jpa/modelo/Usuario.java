package idat.edu.pe.cautela.jpa.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name="usuario")

@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query = "SELECT u FROM Usuario u")
	,@NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
	, @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
	, @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")
	, @NamedQuery(name = "Usuario.findByFecha", query = "SELECT u FROM Usuario u WHERE u.fecha = :fecha")
	, @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
	, @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")})


public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Basic(optional = false)
	@Column(name="email")
	private String email;
	
	@Basic(optional = false)
	@Column(name="pass")
	private String pass;
	
	@Basic(optional = false)
	@Column(name= "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Basic(optional = false)
	@Column(name="nombres")
	private String nombres;
	
	@Basic(optional = false)
	@Column(name="apellidos")
	private String apellidos;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "fk_idUsuarioCarrito")
	private List<Carrito> carritoLista;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_idUsuarioDomicilio")
	private List<Domicilio> domicilioLista;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="fk_idUsuarioOrden")
	private List<Orden> ordenLista;
	
	
       public Usuario() {
		
	}
       
       
	
	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public Usuario(Integer idUsuario, String email, String pass, Date fecha, String nombres, String apellidos) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.pass = pass;
		this.fecha = fecha;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@XmlTransient
    public List<Carrito> getCarritoLista() {
        return carritoLista;
    }

    public void setCarritoLisat(List<Carrito> carritoLista) {
        this.carritoLista = carritoLista;
    }
  
    public List<Domicilio> getDomicilioLista() {
        return domicilioLista;
    }

    public void setDomicilioLista(List<Domicilio> domicilioLista) {
        this.domicilioLista = domicilioLista;
    }
   
    public List<Orden> getOrdenLista() {
        return ordenLista;
    }

    public void setOrdenLista(List<Orden> ordenLista) {
        this.ordenLista = ordenLista;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    

	
	
	

}
