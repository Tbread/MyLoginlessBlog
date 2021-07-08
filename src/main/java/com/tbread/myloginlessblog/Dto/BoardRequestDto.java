package com.tbread.myloginlessblog.Dto;

import com.tbread.myloginlessblog.models.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {
    private String username;
    private String title;
    private int countview;
    private String contents;
    private LocalDateTime createdAt;

    public BoardRequestDto(Board entity){
        this.username = entity.getUsername();
        this.countview = entity.getCountview();
        this.contents = entity.getContents();
        this.title = entity.getTitle();
        this.createdAt = entity.getCreatedAt();
    }
}
