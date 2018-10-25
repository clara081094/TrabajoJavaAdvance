package pe.edu.cibertec.spring.base.service;

import java.util.List;

import pe.edu.cibertec.spring.base.dominio.Producto;

public interface ProductoServicio 
extends Servicio<Producto> {
    
	List<Producto> listaPorCategoria(Integer id); 
}
