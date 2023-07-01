package com.ybus.ybusapiserver.JPA.repository.board;

import com.ybus.ybusapiserver.JPA.Entity.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post getByPostSeq(Long postSeq);
}
