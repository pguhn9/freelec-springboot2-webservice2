package com.gunedu.book.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //get 메서드 생성
@RequiredArgsConstructor  //생성자 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
