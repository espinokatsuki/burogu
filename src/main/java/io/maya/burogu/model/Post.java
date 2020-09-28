package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private @Id
    @GeneratedValue
    Integer id;
    private String title;
    private String description;
    private @Column(name = "author_id")
    Integer authorId;
    private @Column(name = "created_at")
    LocalDateTime createdAt;
    private @Column(name = "subreddit_id")
    Integer subredditId;
    private @Column(name = "up_votes")
    Integer upVotes;
    private @Column(name = "down_votes")
    Integer downVotes;
    private Boolean active;
    private @ManyToOne
    @JoinColumn(name = "author_id", updatable = false, insertable = false)
    User user;
    private @ManyToOne
    @JoinColumn(name = "subreddit_id", updatable = false, insertable = false)
    Subreddit subreddit;
    private @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL})
    List<Comment> comments;
    private @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL})
    List<SavedPosts> savedPosts;
}
