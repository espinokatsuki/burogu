package io.maya.burogu.mapper;

import io.maya.burogu.dto.UserDto;
import io.maya.burogu.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> users);

    @Mappings({
            @Mapping(target = "followers", ignore = true),
            @Mapping(target = "comments", ignore = true),
            @Mapping(target = "posts", ignore = true),
            @Mapping(target = "savedPosts", ignore = true),
            @Mapping(target = "subreddits", ignore = true)
    })
    @InheritInverseConfiguration
    User toUser(UserDto userDto);

    List<User> toUserList(List<UserDto> userDtos);
}
