package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subreddits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subreddit {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    private String description;
    private @Column(name = "creator_id")
    Integer creatorId;
    private String type;
    private Boolean active;
    private @Column(name = "created_at")
    LocalDateTime createdAt;
    private @ManyToOne
    @JoinColumn(name = "creator_id", updatable = false, insertable = false)
    User user;
    private @OneToMany(mappedBy = "subreddit", cascade = {CascadeType.ALL})
    List<Follower> followers;
    private @OneToMany(mappedBy = "subreddit", cascade = {CascadeType.ALL})
    List<Post> posts;
}
