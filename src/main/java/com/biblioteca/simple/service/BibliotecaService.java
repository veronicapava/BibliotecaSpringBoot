package com.biblioteca.simple.service;

import com.biblioteca.simple.model.Biblioteca;
import com.biblioteca.simple.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Iterable<Biblioteca> list(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca save(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> recursoPorTipo(String tipoRecurso){
        return bibliotecaRepository.findByTipoRecurso(tipoRecurso);
    }

    public List<Biblioteca> recursoPorNombre(String nombreRecurso){
        return bibliotecaRepository.findByNombreRecurso(nombreRecurso);
    }

    public String status(String id){
        var recurso = bibliotecaRepository.findById(id);
                if(recurso.isEmpty() ){
                    return "No encontré el recurso";
                }
                if(recurso.get().isDisponible()){
                    return "El recurso se encuentra disponible";
                }
                return "El recurso no se encuentra disponible";
    }

    public String prestarRecurso(String id){
        var recurso = bibliotecaRepository.findById(id);
        if(recurso.isEmpty() ){
            return "No encontré el recurso";
        }
        if(recurso.get().isDisponible()){
            var editado = recurso.get();
            editado.setDisponible(false);
            editado.setFechaPrestamo(String.valueOf(LocalDate.now()));
            bibliotecaRepository.save(editado);
            return "El recurso se prestó ";
        }
        return "El recurso no se encuentra disponible para prestar";

    }

    public String devolverRecurso(String id){
        var recurso = bibliotecaRepository.findById(id);
        if(recurso.isEmpty() ){
            return "No encontré el recurso";
        }
        if(!recurso.get().isDisponible()){
            var editado = recurso.get();
            editado.setDisponible(true);
            editado.setFechaPrestamo("0000-00-00");
            bibliotecaRepository.save(editado);
            return "El recurso se devolvió ";
        }
        return "El recurso no se encuentra disponible para devolver";

    }




}
