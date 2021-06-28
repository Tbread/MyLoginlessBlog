package com.tbread.myloginlessblog.service;

import com.tbread.myloginlessblog.models.Board;
import com.tbread.myloginlessblog.models.BoardListRequestDto;
import com.tbread.myloginlessblog.models.BoardRepository;
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
}
