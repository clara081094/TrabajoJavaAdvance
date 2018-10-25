package pe.edu.cibertec.spring.base.repository;

import java.util.List;
import java.util.Map;

public interface Repositorio<E> {

    void guardar(E entidad);
    void actualizar(E entidad);
    void eliminar(E entidad);
    E obtenerPorId(Integer id);
    List<E> obtenerTodos();
    List findWithQuery(String namedQueryName);
    List findWithQuery(String jpaQuery,Map<String,Object> parameters);

}
