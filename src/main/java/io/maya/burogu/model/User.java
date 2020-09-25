package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private @Column(name = "user_name")
    String userName;
    private String password;
    private String email;
    private String biography;
    private String avatar;
    private @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<Subreddit> subreddits;
    private @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<Follower> followers;
    private @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<Post> posts;
    private @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<Comment> comments;
    private @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<SavedPosts> savedPosts;
}
