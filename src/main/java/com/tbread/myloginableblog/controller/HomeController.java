package com.tbread.myloginableblog.controller;

import com.tbread.myloginableblog.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/write")
    public String write(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "write";
    }

    @GetMapping("modify/{id}")
    public String modify(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("id", id);
        return "modify";
    }

    @GetMapping("articles/{id}")
    public String article(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        model.addAttribute("username", userDetails.getUsername()); // 비회원으로 접근시 해당 부분 호출에서 null에려가 난다
        model.addAttribute("id", id);
        try {
            model.addAttribute("username", userDetails.getUsername());
        } catch (NullPointerException e) {
            model.addAttribute("username","not_login_user"); // catch로 유저가 null이라면 잡아주기, 그런게 이게 최선일까?
        }
        return "articles";
    }


}
