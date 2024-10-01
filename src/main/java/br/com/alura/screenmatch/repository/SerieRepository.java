package br.com.alura.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
	
	Optional<List<Serie>> findByAvaliacaoGreaterThan(Double numeroComparacao);

	List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);

	List<Serie> findTop3ByOrderByAvaliacaoDesc();

	List<Serie> findByGenero(Categoria categoria);

	@Query("select s from Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
	List<Serie> seriesPorTemporadaEAValiacao(int totalTemporadas, double avaliacao);

	@Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
	List<Episodio> episodiosPorTrecho(String trechoEpisodio);
}
