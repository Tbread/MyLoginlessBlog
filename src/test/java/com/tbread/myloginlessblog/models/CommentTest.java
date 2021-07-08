package com.tbread.myloginlessblog.models;

import com.tbread.myloginlessblog.Dto.BoardRequestDto;
import com.tbread.myloginlessblog.Dto.CommentRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
    @Test
    @DisplayName("정상 케이스")
    void createComment_Normal() {
        // given
        Long id = 100L;
        Long board_id = 13L;
        String username = "테스트유저";
        String contents = "테스트내용";


        CommentRequestDto requestDto = new CommentRequestDto(id,board_id,username,contents);

        // when
        Comment comment = new Comment(requestDto);

        // then
        assertEquals(100L,comment.getId());
        assertEquals(13L, comment.getBoard_id());
        assertEquals(username, comment.getUsername());
        assertEquals(contents, comment.getContents());

    }

}