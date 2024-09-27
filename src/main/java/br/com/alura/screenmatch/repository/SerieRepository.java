package br.com.alura.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
	
	Optional<List<Serie>> findByAvaliacaoGreaterThan(Double numeroComparacao);

}
