package pe.edu.cibertec.spring.base.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.repository.ProductoSkuRepositorio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

@Service
public class ProductoSkuServicioImpl
    extends ServicioBase<ProductoSku>
    implements ProductoSkuServicio {

    public ProductoSkuServicioImpl(ProductoSkuRepositorio productoSkuRepositorio) {
        super(productoSkuRepositorio);
    }
    
    @Override
	public List<ProductoSku> listaDetallesPorCategoria(Integer id) {
		
		HashMap<String, Object> parametros= new HashMap<String, Object>();	
	     parametros.put("categoria", id);	
	    
	     String query="select p from ProductoSku p  where p.producto.categoria.id=:categoria";
	   	 List<ProductoSku> lista = findWithQuery(query, parametros);
		 return lista;
	}

	@Override
	public ProductoSku detallesPorIdProducto(Integer id) {
		
		HashMap<String, Object> parametros= new HashMap<String, Object>();	
	     parametros.put("productoId", id);	
	    
	     String query="select p from ProductoSku p  where p.producto.id=:productoId";
	   	 List<ProductoSku> listaP = findWithQuery(query, parametros);
	   	 
	   	 if(!listaP.isEmpty()||listaP.size()>0)
	   		 return listaP.get(0);
	   	 else
	   		 return null;
	}
    
}
