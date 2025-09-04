package br.com.dio.kanbanconsole.service;

import br.com.dio.kanbanconsole.dto.CreateCardDto;
import br.com.dio.kanbanconsole.model.Board;
import br.com.dio.kanbanconsole.model.KanbanCard; // <-- MUDANÇA AQUI
import br.com.dio.kanbanconsole.repository.BoardRepository;
import br.com.dio.kanbanconsole.repository.KanbanCardRepository; // <-- MUDANÇA AQUI
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardCommandService {
    private final KanbanCardRepository cardRepository; // <-- MUDANÇA AQUI
    private final BoardRepository boardRepository;

    public CardCommandService(KanbanCardRepository cardRepository, BoardRepository boardRepository) { // <-- MUDANÇA AQUI
        this.cardRepository = cardRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public KanbanCard createCard(CreateCardDto dto) { // <-- MUDANÇA AQUI
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board não encontrado!"));
        KanbanCard newCard = new KanbanCard(); // <-- MUDANÇA AQUI
        newCard.setTitle(dto.getTitle());
        newCard.setBoard(board);
        return cardRepository.save(newCard);
    }

    @Transactional
    public KanbanCard moveCard(Long cardId, Long newBoardId) { // <-- MUDANÇA AQUI
        KanbanCard card = cardRepository.findById(cardId) // <-- MUDANÇA AQUI
                .orElseThrow(() -> new RuntimeException("Card não encontrado!"));
        Board newBoard = boardRepository.findById(newBoardId)
                .orElseThrow(() -> new RuntimeException("Board de destino não encontrado!"));
        card.setBoard(newBoard);
        return cardRepository.save(card);
    }
}