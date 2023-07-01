package com.ybus.ybusapiserver.Service;

import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;

public interface BoardService {

    void writePost(PostDTO postDTO);
    void writeComment(CommentDTO commentDTO);
    String getPostInfoToSeq(Long postSeq);

    String getPostInfoAll();
    String getCommentInfo(Long postSeq);

}
