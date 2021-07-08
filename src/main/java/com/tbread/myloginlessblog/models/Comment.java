package com.tbread.myloginlessblog.models;

import com.tbread.myloginlessblog.Dto.CommentPutRequestDto;
import com.tbread.myloginlessblog.Dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends TimeStamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long board_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment(CommentRequestDto requestDto){
        this.id = requestDto.getId();
        this.board_id = requestDto.getBoard_id();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(CommentPutRequestDto requestDto){
        this.contents = requestDto.getContents();
    }

}
