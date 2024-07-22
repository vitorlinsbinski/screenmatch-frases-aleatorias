package br.com.alura.screenmatchfrasesaleatorias.repository;

import br.com.alura.screenmatchfrasesaleatorias.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
   @Query("SELECT q from Quote q ORDER BY q.id DESC LIMIT 1")
   Optional<Quote> findTopByOrderByDesc();
}
