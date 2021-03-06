package com.tbread.myloginableblog.service;

import com.tbread.myloginableblog.Dto.CommentPutRequestDto;
import com.tbread.myloginableblog.models.Comment;
import com.tbread.myloginableblog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentPutRequestDto commentPutRequestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        comment.update(commentPutRequestDto);
        return comment.getId();
    }

    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        commentRepository.delete(comment);
    }
}

