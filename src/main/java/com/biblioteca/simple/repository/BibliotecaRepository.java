package com.biblioteca.simple.repository;

import com.biblioteca.simple.model.Biblioteca;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BibliotecaRepository extends MongoRepository<Biblioteca, String> {

    List<Biblioteca> findByTipoRecurso(String tipoRecurso);

    List<Biblioteca> findByNombreRecurso(String nombreRecurso);
}
