
package com.elobservador.noticiero.service;

import com.elobservador.noticiero.entidades.Noticia;
import com.elobservador.noticiero.excepcions.MiExceptions;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elobservador.noticiero.repositorio.NoticiaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class NoticiaService {
    
    @Autowired
    NoticiaRepository noticiaRepository;
    
    @Transactional
    public void crearNoticia(Long id, String titulo, String cuerpo ) throws MiExceptions {
         
        Noticia noticia= new Noticia();
        
        validar(id,titulo,cuerpo);
        noticia.setId(id);
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setVisualizar(true);
       
        noticiaRepository.save(noticia);
    }
    
    public List<Noticia> listarNoticias(){
        
        List<Noticia> noticias= new ArrayList();
        
        noticias= noticiaRepository.findAll();
        return noticias;
    }
    
    public void modificarNoticia(String titulo, String cuerpo, Long id) throws MiExceptions {
        validar(id, titulo,cuerpo);
        Optional <Noticia> respuesta= noticiaRepository.findById(id);
        
        if(respuesta.isPresent()){
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticiaRepository.save(noticia);
        }
    }
    
    public void darBaja(Long id){
        
        Optional <Noticia> respuesta= noticiaRepository.findById(id);
        if(respuesta.isPresent()){
            Noticia noticia=respuesta.get();
            noticia.setVisualizar(false);
            noticiaRepository.save(noticia);
        }
        
    }
    
    public Noticia getOne(Long id){
       return noticiaRepository.getOne(id);
        
    }
    
    public void validar(Long id, String titulo, String cuerpo) throws MiExceptions {
        
        if( id==null){
            throw new MiExceptions("El id no puede ser nulo");
        }
        
        if(titulo.isEmpty()|| titulo == null){
            throw new MiExceptions("El titulo no puede estar vacio o nulo");
            
            
        }
        if(cuerpo.isEmpty()|| cuerpo == null){
             throw new MiExceptions("El cuerpo tiene que tener algun contenido");
            
        }
        
    }
    
}
