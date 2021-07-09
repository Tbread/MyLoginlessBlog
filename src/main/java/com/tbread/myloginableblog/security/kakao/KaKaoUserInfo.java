package com.tbread.myloginableblog.security.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KaKaoUserInfo {
    Long id;
    String email;
    String nickname;
}
