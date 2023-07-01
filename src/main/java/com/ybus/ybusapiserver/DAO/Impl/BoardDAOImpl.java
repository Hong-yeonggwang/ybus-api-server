package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BoardDAO;
import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;
import com.ybus.ybusapiserver.JPA.Entity.board.Post;
import com.ybus.ybusapiserver.JPA.repository.board.CommentRepository;
import com.ybus.ybusapiserver.JPA.repository.board.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardDAOImpl implements BoardDAO {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private EntityFactory entityFactory;

    @Autowired
    public BoardDAOImpl(PostRepository postRepository, CommentRepository commentRepository
    , EntityFactory entityFactory){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.entityFactory = entityFactory;
    }


    @Override
    public void writedPost(PostDTO postDTO) {
        Post post = entityFactory.postToEntity(postDTO);
        postRepository.save(post);
        postRepository.flush();

    }

    @Override
    public void writedCommnet(CommentDTO commentDTO) {
        Comment comment = entityFactory.commentToEntity(commentDTO);
        commentRepository.save(comment);
        commentRepository.flush();
    }

    @Override
    public Post getPostInfoToSeq(Long postSeq) {
        Post post = postRepository.getByPostSeq(postSeq);
        return post;
    }

    @Override
    public List<Post> getPostInfoAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Comment> getCommentToPostSeq(Long postSeq) {
        Post post = new Post();
        post.setPostSeq(postSeq);
        List<Comment> commentList = commentRepository.getByPostSeq(post);
        return commentList;
    }
}
