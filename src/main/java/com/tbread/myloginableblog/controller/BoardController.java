package com.tbread.myloginableblog.controller;

import com.tbread.myloginableblog.models.Board;
import com.tbread.myloginableblog.Dto.BoardListRequestDto;
import com.tbread.myloginableblog.repository.BoardRepository;
import com.tbread.myloginableblog.Dto.BoardRequestDto;
import com.tbread.myloginableblog.service.BoardService;
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
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping("api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("api/boards/{id}")
    public BoardRequestDto searchById(@PathVariable Long id) {
        return boardService.searchById(id);
    }

    @DeleteMapping("api/boards/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

    @PutMapping("api/boards/{id}")
    public Long updateArticle(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        if (requestDto.getUsername().equals(boardService.searchById(id).getUsername())) {
            System.out.println(requestDto.getUsername());
            System.out.println(boardService.searchById(id).getUsername());
            System.out.println("같으니까 바꿈");
            return boardService.updateArticle(id, requestDto);
        } else {
            System.out.println(requestDto.getUsername());
            System.out.println(boardService.searchById(id).getUsername());
            System.out.println("다르니까안바꿈");
            return boardService.updateArticle(id, boardService.searchById(id));
        }
    }

    @PutMapping("api/boards/view/{id}")
    public Long updateView(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateView(id, requestDto);
    }


}
