package io.maya.burogu.mapper;

import io.maya.burogu.dto.PostDto;
import io.maya.burogu.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mappings({
            @Mapping(target = "subredditName", expression = "java(post.getSubreddit().getName())"),
            @Mapping(target = "subredditType", expression = "java(post.getSubreddit().getType())"),
            @Mapping(target = "author", expression = "java(post.getUser().getUserName())")
    })
    PostDto toPostDto(Post post);

    List<PostDto> toPostDtos(List<Post> posts);

    @Mappings({
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "comments", ignore = true),
            @Mapping(target = "savedPosts", ignore = true)
    })
    @InheritInverseConfiguration
    Post toPost(PostDto postDto);

    List<Post> toPosts(List<PostDto> postDtos);
}
