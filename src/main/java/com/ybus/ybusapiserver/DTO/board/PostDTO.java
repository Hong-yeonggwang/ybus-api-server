package com.ybus.ybusapiserver.DTO.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostDTO {
    private String subject;
    private String content;
    private String writerName;
    private String tag;
}
