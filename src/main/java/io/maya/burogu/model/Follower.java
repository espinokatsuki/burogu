package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "followers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follower {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private @Column(name = "user_id")
    Integer userId;
    private @Column(name = "subreddit_id")
    Integer subredditId;
    private @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    User user;
    private @ManyToOne
    @JoinColumn(name = "subreddit_id", updatable = false, insertable = false)
    Subreddit subreddit;
}
