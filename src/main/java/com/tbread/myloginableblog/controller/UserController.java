package com.tbread.myloginableblog.controller;

import com.tbread.myloginableblog.Dto.DubChkRequestDto;
import com.tbread.myloginableblog.Dto.SignupRequestDto;
import com.tbread.myloginableblog.security.UserDetailsImpl;
import com.tbread.myloginableblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
        } catch (NullPointerException e) {
            model.addAttribute("username","not_login_user"); // catch로 유저가 null이라면 잡아주기, 그런게 이게 최선일까?
        }
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/user/dupchk")
    @ResponseBody
    public Boolean dupchk(@RequestBody DubChkRequestDto requestDto){
        return userService.dubChk(requestDto);
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code) {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);

        return "redirect:/";
    }


}