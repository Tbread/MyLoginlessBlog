package com.tbread.myloginlessblog.controller;

import com.tbread.myloginlessblog.models.Board;
import com.tbread.myloginlessblog.models.BoardListRequestDto;
import com.tbread.myloginlessblog.models.BoardRepository;
import com.tbread.myloginlessblog.models.BoardRequestDto;
import com.tbread.myloginlessblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("api/boards")
    public List<Board> readBoard(BoardListRequestDto requestDto) {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
}
