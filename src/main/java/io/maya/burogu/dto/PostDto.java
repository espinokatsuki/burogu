package io.maya.burogu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer id;
    private String title;
    private String description;
    private String author;
    private String subredditName;
    private String subredditType;
    private LocalDateTime createdAt;
    private Integer upVotes;
    private Integer downVotes;
    private Boolean active;
}
