package com.tbread.myloginableblog.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentPutRequestDto {
    private String contents;
}
