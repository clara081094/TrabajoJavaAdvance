package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.Usuario;

public interface UsuarioServicio
        extends Servicio<Usuario> {
    Usuario verSiExiste(Usuario usuario);
}
