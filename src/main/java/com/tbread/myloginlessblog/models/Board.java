package com.tbread.myloginlessblog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@Getter
@Entity
public class Board extends TimeStamped {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int countview;

    public Board(String username, String title, String contents, int countview) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.countview = countview;
    }

    public Board(BoardRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.countview = requestDto.getCountview();
        this.contents = requestDto.getContents();
    }

    public void update(BoardListRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.countview = requestDto.getCountview();
    }


}
