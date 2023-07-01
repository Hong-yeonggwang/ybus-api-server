package com.ybus.ybusapiserver.DTO.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentDTO {
    private String content;
    private String writerName;
    private Long postSeq;
}
