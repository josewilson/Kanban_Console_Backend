package br.com.dio.kanbanconsole.repository;

import br.com.dio.kanbanconsole.model.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    /**
     * Sobrescreve o método findAll() padrão para garantir que a coleção 'cards'
     * seja carregada junto com os Boards, evitando a LazyInitializationException.
     * @return Uma lista de Boards com seus cards já inicializados.
     */
    @Override
    @EntityGraph(attributePaths = "cards")
    List<Board> findAll();
}