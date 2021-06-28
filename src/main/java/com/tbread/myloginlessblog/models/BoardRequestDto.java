package com.tbread.myloginlessblog.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {
    private String username;
    private String title;
    private int countview;
    private String contents;
}
