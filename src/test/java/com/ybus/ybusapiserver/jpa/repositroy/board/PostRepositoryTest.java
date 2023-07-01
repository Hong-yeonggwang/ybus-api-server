package com.ybus.ybusapiserver.jpa.repositroy.board;

import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;
import com.ybus.ybusapiserver.JPA.Entity.board.Post;
import com.ybus.ybusapiserver.JPA.repository.board.CommentRepository;
import com.ybus.ybusapiserver.JPA.repository.board.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Test
    @Transactional
    public void postFindTest(){
        Post post = postRepository.getByPostSeq(2L);
        System.out.println(post);
    }
    @Test
    public void commentListFind(){
        Post post = new Post();
        post.setPostSeq(2L);
        List<Comment> commentList = commentRepository.getByPostSeq(post);
        commentList.forEach(name -> System.out.println(name.getPostSeq()));
    }
}
