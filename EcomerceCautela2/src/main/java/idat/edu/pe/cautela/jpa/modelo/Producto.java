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
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByFecha", query = "SELECT p FROM Producto p WHERE p.fecha = :fecha")
    ,@NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")})

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idProducto")
	private Integer idProducto;
	
	@Basic(optional = false)
	@Column(name="nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name="fecha")
	private Date fecha;
	
	@Basic(optional = false)
	@Column(name="precio")
	private Double precio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_idProductoCarrito")
	private List<Carrito> carritoListadoP;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Producto(Integer idProducto) {
		this.idProducto = idProducto;
	}




	public Producto(Integer idProducto, String nombre, Date fecha, Double precio) {

		this.idProducto = idProducto;
		this.nombre = nombre;
		this.fecha = fecha;
		this.precio = precio;
	}
	
	



	public Integer getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@XmlTransient
    public List<Carrito> getCarritoListadoP() {
        return carritoListadoP;
    }

    public void setCarritoListadoP(List<Carrito> carritoListadoP) {
        this.carritoListadoP = carritoListadoP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Producto[ idProducto=" + idProducto + " ]";
    }


	
	

}
