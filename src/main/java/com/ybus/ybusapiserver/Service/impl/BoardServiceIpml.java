package com.ybus.ybusapiserver.Service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ybus.ybusapiserver.DAO.BoardDAO;
import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;
import com.ybus.ybusapiserver.JPA.Entity.board.Post;
import com.ybus.ybusapiserver.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceIpml implements BoardService {
    private BoardDAO boardDAO;

    @Autowired
    public BoardServiceIpml(BoardDAO boardDAO){
        this.boardDAO = boardDAO;
    }
    @Override
    public void writePost(PostDTO postDTO){
        boardDAO.writedPost(postDTO);
    }

    @Override
    public void writeComment(CommentDTO commentDTO) {
        boardDAO.writedCommnet(commentDTO);
    }

    @Override
    public String getPostInfoToSeq(Long postSeq) {
        Post post = boardDAO.getPostInfoToSeq(postSeq);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String postJson = objectMapper.writeValueAsString(post);
            return postJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }

    }

    @Override
    public String getPostInfoAll() {

        List<Post> post = boardDAO.getPostInfoAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String postJson = objectMapper.writeValueAsString(post);
            return postJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }
    }

    @Override
    public String getCommentInfo(Long postSeq) {
        List<Comment> commentList = boardDAO.getCommentToPostSeq(postSeq);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String commentJson = objectMapper.writeValueAsString(commentList);
            return commentJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }
    }
}
