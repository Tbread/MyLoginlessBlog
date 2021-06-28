package com.tbread.myloginlessblog.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardListRequestDto {
    private String username;
    private String title;
    private int countview;
}
