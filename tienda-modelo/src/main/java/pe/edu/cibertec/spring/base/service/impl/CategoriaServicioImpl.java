/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.repository.CategoriaRepositorio;
import pe.edu.cibertec.spring.base.repository.Repositorio;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;

/**
 *
 * @author JAdv-MJ
 */
@Service
public class CategoriaServicioImpl 
        extends ServicioBase<Categoria>
    implements CategoriaServicio {
    
    public CategoriaServicioImpl(CategoriaRepositorio categoriaRepositorio) {
        super(categoriaRepositorio);
    }
    
}
