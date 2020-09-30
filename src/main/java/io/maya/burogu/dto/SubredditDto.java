package io.maya.burogu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubredditDto {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private Boolean active;
    private LocalDateTime createdAt;
    private Integer followersCount;
}
