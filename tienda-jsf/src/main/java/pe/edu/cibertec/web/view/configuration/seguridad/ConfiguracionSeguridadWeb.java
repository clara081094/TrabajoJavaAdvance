/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.configuration.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

/**
 *
 * @author JAdv-MJ
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridadWeb extends WebSecurityConfigurerAdapter{
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
         .csrf().disable() //OJO SOLO POR MOTIVO DE PRUEBAS
                           //EN PRODUCCIONN SIEMPRE DEBERIA ESTAR HABILITADO
         .authorizeRequests()
                .antMatchers("/","/usuario/nuevo.html")
                .permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login.xhtml")
                .loginProcessingUrl("/login")
                .usernameParameter("correoElectronico")
                .passwordParameter("contrasena")
                .defaultSuccessUrl("/productos.xhtml")
                .failureUrl("/login.xhtml?error=true")
                .permitAll()
                ;
    }
    
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
    	
    	
    	UserDetails user = User.withDefaultPasswordEncoder()
                    .username("luiggi")
                    .password("123456")
                    .roles("USUARIO")
                    .build();
    	
    	
          return new InMemoryUserDetailsManager(user);
    }
    
}
