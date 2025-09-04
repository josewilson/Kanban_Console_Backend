package br.com.dio.kanbanconsole.dto;

import lombok.Data;

@Data
public class CreateCardDto {
    private String title;
    private Long boardId;
}