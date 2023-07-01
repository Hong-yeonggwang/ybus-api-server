package com.ybus.ybusapiserver.JPA.Entity.board;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Post")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSTSEQ")
    private Long postSeq;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "CONTENT")
    @Lob
    private String content;

    @Column(name = "WRITER")
    private String writer;

    @Column(name = "TAG")
    private String tag;

    @Column(name = "WRITEDTIME")
    private LocalDateTime writedTime;

    @Column(name = "STATE")
    private String state;


}
