package pe.edu.cibertec.spring.base.service;

import java.util.List;

import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;

public interface ProductoSkuServicio
    extends Servicio<ProductoSku> {
	List<ProductoSku> listaDetallesPorCategoria(Integer id); 
	ProductoSku detallesPorIdProducto(Integer id);
}
