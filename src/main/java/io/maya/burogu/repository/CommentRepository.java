package io.maya.burogu.repository;

import io.maya.burogu.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<List<Comment>> findByAuthorId(Integer id);

    Optional<List<Comment>> findByPostId(Integer id);
}
