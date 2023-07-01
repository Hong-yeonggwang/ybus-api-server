package com.ybus.ybusapiserver.JPA.Entity.board;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENTSEQ")
    private Long commentSeq;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "WRITER")
    private String writer;

    @Column(name = "WRITEDTIME")
    private LocalDateTime writedTime;

    @Column(name = "STATE")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post postSeq;
}
