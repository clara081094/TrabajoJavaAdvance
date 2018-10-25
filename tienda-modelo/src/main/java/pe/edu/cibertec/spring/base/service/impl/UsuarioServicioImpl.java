package pe.edu.cibertec.spring.base.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

@Service
public class UsuarioServicioImpl
    extends ServicioBase<Usuario>
    implements UsuarioServicio {

    
    public UsuarioServicioImpl(
            UsuarioRepositorio usuarioRepositorio) {
        super(usuarioRepositorio);
    }
    
    @Override
    public Usuario verSiExiste(Usuario usuario){
    	
    	 HashMap<String, Object> parametros= new HashMap<String, Object>();	
	     parametros.put("usuario", usuario.getCorreoElectronico());	
	     parametros.put("passw", usuario.getContrasena());	
	    
	     String query="select u from Usuario u  where u.correoElectronico=:usuario and u.contrasena=:passw";
	   	 List<Usuario> rpta = findWithQuery(query, parametros);
		 System.out.println("rpta: "+rpta.size());
		
		if(rpta.size()!=0)
			return rpta.get(0);
		
		else
			return null;
    }
}
