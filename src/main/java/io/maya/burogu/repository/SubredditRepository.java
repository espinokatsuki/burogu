package io.maya.burogu.repository;

import io.maya.burogu.model.Post;
import io.maya.burogu.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubredditRepository extends JpaRepository<Subreddit, Integer> {
    @Query(value = "SELECT * FROM subreddits INNER JOIN followers f on subreddits.id = f.subreddit_id WHERE user_id = ?",
            nativeQuery = true)
    Optional<List<Post>> findFollowedsubredditsByUserIdNative(Integer id);

    Optional<List<Subreddit>> findByType(String type);

    Optional<List<Subreddit>> findByCreatorId(Integer id);

    Optional<List<Subreddit>> findByCreatorIdAndActiveIsTrue(Integer id);
}
