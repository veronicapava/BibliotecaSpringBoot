package com.biblioteca.simple.controller;

import com.biblioteca.simple.model.Biblioteca;
import com.biblioteca.simple.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaservice;

    @GetMapping(value="/biblioteca")
    public Iterable<Biblioteca> list(){
        return bibliotecaservice.list();
    }

    @PostMapping(value = "/biblioteca")
    public Biblioteca save(@RequestBody Biblioteca biblioteca){
        return bibliotecaservice.save(biblioteca);
    }

    @GetMapping(value="/biblioteca/nombre/{nombre}")
    public List<Biblioteca> listaDeRecursoPorNombre(@PathVariable("nombre")String nombreRecurso){
        return bibliotecaservice.recursoPorNombre(nombreRecurso);
    }

    @GetMapping(value="/biblioteca/tipo/{tipo}")
    public List<Biblioteca> listaRecursoPorTipo(@PathVariable("tipo")String tipoRecurso){
        return bibliotecaservice.recursoPorTipo(tipoRecurso);
    }

    @GetMapping(value="/biblioteca/status/{id}")
    public String verificarDisponibilidad(@PathVariable("id")String id){
        return bibliotecaservice.status(id);
    }





}
