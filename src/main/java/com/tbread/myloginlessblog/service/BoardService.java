package com.tbread.myloginlessblog.service;

import com.tbread.myloginlessblog.models.Board;
import com.tbread.myloginlessblog.Dto.BoardListRequestDto;
import com.tbread.myloginlessblog.repository.BoardRepository;
import com.tbread.myloginlessblog.Dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardListRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는글입니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    @Transactional
    public BoardRequestDto searchById(Long id){
        Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는글입니다.")
        );
        return new BoardRequestDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는글입니다.")
        );
        boardRepository.delete(board);
    }

    @Transactional
    public Long updateArticle(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는글입니다.")
        );
        board.updateArticle(requestDto.getTitle(),requestDto.getContents());
        return id;
    }

    @Transactional
    public Long updateView(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는글입니다.")
        );
        board.updateView(requestDto.getCountview());
        return id;
    }
}
