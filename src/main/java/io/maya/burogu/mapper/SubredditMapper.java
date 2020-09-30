package io.maya.burogu.mapper;

import io.maya.burogu.dto.SubredditDto;
import io.maya.burogu.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {
    @Mapping(expression = "java(subreddit.getFollowers().size())", target = "followersCount")
    SubredditDto toSubredditDto(Subreddit subreddit);

    List<SubredditDto> toSubredditDtos(List<Subreddit> subreddits);

    @Mappings({
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "posts", ignore = true)
    })
    @InheritInverseConfiguration
    Subreddit toSubreddit(SubredditDto subredditDto);

    List<Subreddit> toSubreddits(List<SubredditDto> subredditDtos);
}
