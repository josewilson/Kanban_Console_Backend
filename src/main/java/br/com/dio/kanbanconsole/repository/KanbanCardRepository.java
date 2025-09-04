package br.com.dio.kanbanconsole.repository;

import br.com.dio.kanbanconsole.model.KanbanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanCardRepository extends JpaRepository<KanbanCard, Long> {}