package pe.edu.cibertec.spring.base.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;

@Repository
public class UsuarioRepositorioJpaImpl
    extends RepositorioBaseJpaImpl<Usuario>
        implements UsuarioRepositorio {
	
}
