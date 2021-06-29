package com.tbread.myloginlessblog.controller;

import com.tbread.myloginlessblog.models.Board;
import com.tbread.myloginlessblog.models.BoardListRequestDto;
import com.tbread.myloginlessblog.models.BoardRepository;
import com.tbread.myloginlessblog.models.BoardRequestDto;
import com.tbread.myloginlessblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("api/boards")
    public List<Board> readBoardList(BoardListRequestDto requestDto) {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("api/boards/{id}")
    public BoardRequestDto searchById(@PathVariable Long id){
        return boardService.searchById(id);
    }

    @DeleteMapping("api/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

    @PutMapping("api/boards/{id}")
    public Long updateArticle(@PathVariable Long id,@RequestBody BoardRequestDto requestDto){
        return boardService.updateArticle(id, requestDto);
    }


}
