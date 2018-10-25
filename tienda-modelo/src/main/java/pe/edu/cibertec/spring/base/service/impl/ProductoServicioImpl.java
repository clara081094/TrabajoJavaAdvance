package pe.edu.cibertec.spring.base.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.repository.ProductoRepositorio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

@Service
public class ProductoServicioImpl 
	extends ServicioBase<Producto>
	implements ProductoServicio {

	 public ProductoServicioImpl(
	            ProductoRepositorio productoRepositorio) {
	        super(productoRepositorio);
	    }

	@Cacheable(cacheNames="productoCategoriaCache")
	@Override
	public List<Producto> listaPorCategoria(Integer id) {
		
		HashMap<String, Object> parametros= new HashMap<String, Object>();	
	     parametros.put("categoria", id);	
	    
	     String query="select p from Producto p  where p.categoria.id=:categoria";
	   	 List<Producto> lista = findWithQuery(query, parametros);
		 return lista;
	}

}
