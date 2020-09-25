package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "saved_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedPosts {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private @Column(name = "user_id")
    Integer userId;
    private @Column(name = "post_id")
    Integer postId;
    private @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    User user;
    private @ManyToOne
    @JoinColumn(name = "post_id", updatable = false, insertable = false)
    Post post;
}
