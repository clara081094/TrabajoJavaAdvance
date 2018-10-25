package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.repository.ProductoSkuRepositorio;

@Repository
public class ProductoSkuRepositorioJpaImpl
    extends RepositorioBaseJpaImpl<ProductoSku>
    implements ProductoSkuRepositorio {

}
