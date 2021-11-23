package com.julio.oliveira.controleDiabetes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julio.oliveira.controleDiabetes.entidade.Glicemia;

@Repository
public interface IGlicemiaRepositorio extends JpaRepository<Glicemia, Integer> { 
}
