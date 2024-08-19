package com.marketshop.marketshop.controller;

import com.marketshop.marketshop.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 이메일 인증을 위한 컨트롤러
@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail) {

        int number = mailService.sendMail(mail);
        String num = "" + number;

        return num;
    }
}
