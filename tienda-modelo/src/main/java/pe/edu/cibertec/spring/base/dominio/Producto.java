package pe.edu.cibertec.spring.base.dominio;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

@Entity
public class Producto extends Entidad {

    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = ALL)
    private List<ProductoSku> listaSkus;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ProductoSku> getListaSkus() {
        return listaSkus;
    }

    public void setListaSkus(List<ProductoSku> listaSkus) {
        this.listaSkus = listaSkus;
    }

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria
				+  "]";
	}
}
