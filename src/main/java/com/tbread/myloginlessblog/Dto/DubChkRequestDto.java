package com.tbread.myloginlessblog.Dto;

import com.tbread.myloginlessblog.models.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DubChkRequestDto {
    private String username;

    public DubChkRequestDto(User entity) {
        this.username = entity.getUsername();
    }

}
