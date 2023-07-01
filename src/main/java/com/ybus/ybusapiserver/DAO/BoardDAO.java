package com.ybus.ybusapiserver.DAO;

import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;
import com.ybus.ybusapiserver.JPA.Entity.board.Post;

import java.util.List;

public interface BoardDAO {
    void writedPost(PostDTO postDTO) ;
    void writedCommnet(CommentDTO commentDTO);

    Post getPostInfoToSeq(Long postSeq);

    List<Post> getPostInfoAll();

    List<Comment> getCommentToPostSeq(Long postSeq);

}
