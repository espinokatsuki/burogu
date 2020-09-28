package io.maya.burogu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String content;
    private @Column(name = "author_id")
    Integer authorId;
    private @Column(name = "post_id")
    Integer postId;
    private @Column(name = "created_at")
    LocalDateTime createdAt;
    private Boolean active;
    private @ManyToOne
    @JoinColumn(name = "author_id", updatable = false, insertable = false)
    User user;
    private @ManyToOne
    @JoinColumn(name = "post_id", updatable = false, insertable = false)
    Post post;
}
