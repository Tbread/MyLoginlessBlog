package com.tbread.myloginlessblog.controller;

import com.tbread.myloginlessblog.Dto.BoardRequestDto;
import com.tbread.myloginlessblog.Dto.CommentPutRequestDto;
import com.tbread.myloginlessblog.Dto.CommentRequestDto;
import com.tbread.myloginlessblog.models.Comment;
import com.tbread.myloginlessblog.repository.CommentRepository;
import com.tbread.myloginlessblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @GetMapping("api/comment")
    public List<Comment> getComment(@RequestParam(value = "board_id") Long board_id) {
        return commentRepository.findByBoardIdOrderByCreatedAtDesc(board_id);
    }

    @PostMapping("api/comment")
    public Comment create(@RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal.equals("anonymousUser")) {
            throw new IllegalArgumentException("로그인해주세요.");
        }
        return commentRepository.save(comment);
    }

    @DeleteMapping("api/comment/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }

    @PutMapping("api/comment/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentPutRequestDto requestDto){
        return commentService.update(id,requestDto);
    }
}
