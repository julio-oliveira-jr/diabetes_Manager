package com.julio.oliveira.controleDiabetes.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.julio.oliveira.controleDiabetes.entidade.Glicemia;

@Repository
public interface IGlicemiaRepositorio extends JpaRepository<Glicemia, Integer> {
	@Query(nativeQuery = true, value="SELECT * FROM Glicemia G where G.DAT_GLICEMIA = :datGlicemia AND G.HR_GLICEMIA = :hrGlicemia")
	public List<Glicemia> buscarPorDataHorario(LocalDateTime datGlicemia, String hrGlicemia);
	
	@Query(nativeQuery = true, value="SELECT * FROM Glicemia G where G.DAT_GLICEMIA BETWEEN :datLimInf AND :datLimSup")
	public List<Glicemia> buscarPeriodo(LocalDateTime datLimInf, LocalDateTime datLimSup);
	
	@Query(nativeQuery = true, value="SELECT * FROM Glicemia G where G.DAT_GLICEMIA BETWEEN :datInicioSemana AND :datHoje")
	public List<Glicemia> buscarSemana(LocalDateTime datHoje, LocalDateTime datInicioSemana);
}
