package pe.edu.cibertec.web.view.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

@Component //@ManagedBean
@Scope("view") //@ViewScoped
public class DetallesProductos {
  
    private String categoriaId;
    private String productoId;
    private ProductoSku productoSku;
    private List<Categoria> listaCategorias;
    private List<Producto> productos;

    @Autowired
    private CategoriaServicio categoriaServicio;
    
    @Autowired
    private ProductoServicio productoServicio;
    
    @Autowired
    private ProductoSkuServicio productoSkuServicio;
    
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

    public void obtenerProductoSku(){
        setProductoSku(productoSkuServicio.detallesPorIdProducto(Integer.parseInt(productoId)));
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

    /**
     * @return the productoId
     */
    public String getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(String productoId) {
        this.productoId = productoId;
        if(productoId!=null)
        obtenerProductoSku();
    }

    /**
     * @return the productoSku
     */
    public ProductoSku getProductoSku() {
        return productoSku;
    }

    /**
     * @param productoSku the productoSku to set
     */
    public void setProductoSku(ProductoSku productoSku) {
        this.productoSku = productoSku;
    }
     
    
    
    
}