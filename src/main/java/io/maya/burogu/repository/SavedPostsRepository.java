package io.maya.burogu.repository;

import io.maya.burogu.model.SavedPosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedPostsRepository extends JpaRepository<SavedPosts, Integer> {
}
