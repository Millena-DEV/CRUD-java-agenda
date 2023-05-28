package com.prova.java.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prova.java.model.Compromisso;
@Repository
public interface CompromisssoRepository extends JpaRepository<Compromisso, Long> {
    @Query(value = "select c from Compromisso c where trim(c.nome) like %?1%")
	List<Compromisso> buscarPorNome(String nome);

	

}
