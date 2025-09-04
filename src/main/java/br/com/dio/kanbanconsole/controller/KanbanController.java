package br.com.dio.kanbanconsole.controller;

import br.com.dio.kanbanconsole.dto.CreateCardDto;
import br.com.dio.kanbanconsole.model.Board;
import br.com.dio.kanbanconsole.model.KanbanCard;
import br.com.dio.kanbanconsole.service.BoardQueryService;
import br.com.dio.kanbanconsole.service.CardCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kanban") // Define o prefixo da URL para todos os endpoints desta classe
public class KanbanController {

    private final BoardQueryService boardQueryService;
    private final CardCommandService cardCommandService;

    public KanbanController(BoardQueryService boardQueryService, CardCommandService cardCommandService) {
        this.boardQueryService = boardQueryService;
        this.cardCommandService = cardCommandService;
    }

    // Endpoint para visualizar todos os quadros
    // GET http://localhost:8080/api/kanban/boards
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardQueryService.findAllBoardsWithCards();
        return ResponseEntity.ok(boards);
    }

    // Endpoint para criar um novo card
    // POST http://localhost:8080/api/kanban/cards
    @PostMapping("/cards")
    public ResponseEntity<KanbanCard> createCard(@RequestBody CreateCardDto createCardDto) {
        KanbanCard newCard = cardCommandService.createCard(createCardDto);
        return ResponseEntity.ok(newCard);
    }

    // Endpoint para mover um card
    // PUT http://localhost:8080/api/kanban/cards/{cardId}/move/{newBoardId}
    @PutMapping("/cards/{cardId}/move/{newBoardId}")
    public ResponseEntity<KanbanCard> moveCard(
            @PathVariable Long cardId,
            @PathVariable Long newBoardId) {
        KanbanCard movedCard = cardCommandService.moveCard(cardId, newBoardId);
        return ResponseEntity.ok(movedCard);
    }
}