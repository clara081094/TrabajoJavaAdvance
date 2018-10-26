package pe.edu.cibertec.spring.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

@ComponentScan(basePackages = "pe.edu.cibertec.spring.base")
//Si no se agrega la anotación @EnableAspectJAutoProxy
//no se podrán usar los aspectos en la aplicación
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class PrincipalSpringAnotacion {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(
                PrincipalSpringAnotacion.class)) {

        	UsuarioServicio us = ctx.getBean(UsuarioServicio.class);
        	ProductoServicio sps = ctx.getBean(ProductoServicio.class);
                CategoriaServicio cs= ctx.getBean(CategoriaServicio.class);
            ProductoSkuServicio pss = ctx.getBean(ProductoSkuServicio.class);
            ProductoSku ps = pss.obtenerPorId(4);
            System.out.printf("%d %d %s %d %s\n", ps.getId(),
                    ps.getProducto().getId(),
                    ps.getProducto().getNombre(),
                    ps.getProducto().getCategoria().getId(),
                    ps.getProducto().getCategoria().getNombre());
            
            Usuario user = new Usuario();
            user.setCorreoElectronico("claraw");
            user.setContrasena("1234w5");
            
            if(us.verSiExiste(user)!=null)
            	System.out.println("Objeto: " + us.verSiExiste(user));
            else
            	System.out.println("Objeto: es nulo");
            System.out.println("Objeto: " + sps.listaPorCategoria(1).size());
            
            for (int i=0; i<sps.listaPorCategoria(1).size(); i++) {
            	System.out.println("Producto1: "+sps.listaPorCategoria(1).get(i).getNombre());
            }
            
            for (int i=0; i<sps.listaPorCategoria(1).size(); i++) {
            	System.out.println("Producto1: "+sps.listaPorCategoria(1).get(i).getNombre());
            }
            
            for (int i=0; i<sps.listaPorCategoria(2).size(); i++) {
            	System.out.println("Producto2: "+sps.listaPorCategoria(2).get(i).getNombre());
            }
            
            System.out.println("Objeto: " + pss.listaDetallesPorCategoria(1).size());
            
            for (int i=0; i<cs.obtenerTodos().size(); i++) {
            	System.out.println("Categoria: "+ cs.obtenerTodos().get(i).getNombre());
            }
            
        System.out.println("ObtenerTodos: "+pss.obtenerTodos().size());
            
            System.out.println("Detalles producto: " + pss.detallesPorIdProducto(1).getCantidad());
        }
    }
}
