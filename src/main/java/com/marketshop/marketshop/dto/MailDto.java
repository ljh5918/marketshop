package com.marketshop.marketshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 임시 비밀번호 생성 DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {

    private String address;
    private String title;
    private String message;
}
