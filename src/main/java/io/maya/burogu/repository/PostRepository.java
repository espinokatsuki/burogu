package io.maya.burogu.repository;

import io.maya.burogu.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "SELECT * FROM posts INNER JOIN subreddits s on posts.subreddit_id = s.id INNER JOIN followers f " +
            "on s.id = f.subreddit_id WHERE user_id = ?",
            nativeQuery = true)
    Optional<List<Post>> findHomeScreenPostsByUserIdNative(Integer id);

    @Query(value = "SELECT * FROM posts INNER JOIN saved_posts sp on posts.id = sp.post_id WHERE user_id = ?",
            nativeQuery = true)
    Optional<List<Post>> findSavedPostsByUserIdNative(Integer id);

    Optional<List<Post>> findByAuthorId(Integer id);

    Optional<List<Post>> findBySubredditId(Integer id);

    Optional<List<Post>> findBySubredditIdOrderByUpVotesDesc(Integer id);
}
