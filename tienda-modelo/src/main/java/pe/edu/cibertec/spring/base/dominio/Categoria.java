package pe.edu.cibertec.spring.base.dominio;

import javax.persistence.Entity;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

@Entity
public class Categoria extends Entidad {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
