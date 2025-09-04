package br.com.dio.kanbanconsole.service;

import br.com.dio.kanbanconsole.model.Board;
import br.com.dio.kanbanconsole.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BoardQueryService {
    private final BoardRepository boardRepository;

    public BoardQueryService(BoardRepository boardRepository) { // Constructor Injection
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<Board> findAllBoardsWithCards() {
        return boardRepository.findAll();
    }
}