package pe.edu.cibertec.web.view.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

@Component //@ManagedBean
@Scope("view") //@ViewScoped
public class MultiSelect {
  
    private String categoriaId;
    private List<Categoria> listaCategorias;
    private List<Producto> productos;

    @Autowired
    private CategoriaServicio categoriaServicio;
    
    @Autowired
    private ProductoServicio productoServicio;
    
    @PostConstruct
    public void init() {
        listaCategorias = categoriaServicio.obtenerTodos();
        
    }

    /**
     * @return the categoriaId
     */
    public String getCategoriaId() {
        return categoriaId;
    }

    /**
     * @param categoriaId the categoriaId to set
     */
    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
        llenarProductos();
    }
    
    public void llenarProductos(){
        productos=productoServicio.listaPorCategoria(Integer.parseInt(categoriaId));
    }

    /**
     * @return the listaCategorias
     */
    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    /**
     * @param listaCategorias the listaCategorias to set
     */
    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
     
    
    
    
}