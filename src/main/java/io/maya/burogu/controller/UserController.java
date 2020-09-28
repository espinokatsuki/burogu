package io.maya.burogu.controller;

import io.maya.burogu.assembler.UserAssembler;
import io.maya.burogu.dto.UserDto;
import io.maya.burogu.exception.AlreadyExistsException;
import io.maya.burogu.exception.NotFoundException;
import io.maya.burogu.mapper.UserMapper;
import io.maya.burogu.model.User;
import io.maya.burogu.service.IUserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private IUserService userService;
    private UserMapper userMapper;
    private UserAssembler userAssembler;

    public UserController(IUserService userService, UserMapper userMapper, UserAssembler userAssembler) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userAssembler = userAssembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<UserDto>> getAll() {
        List<UserDto> userDtos = userMapper.toUserDtoList(userService.getAll());
        List<EntityModel<UserDto>> entityModels = userDtos.stream()
                .map(userAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(entityModels,
                linkTo(methodOn(UserController.class).getAll()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public EntityModel<UserDto> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        UserDto userDto = userMapper.toUserDto(user);
        return userAssembler.toModel(userDto);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        Optional<User> optionalUser = userService.getByUserNameAndEmail(userDto.getUserName(), userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new AlreadyExistsException("User already exists");
        }
        EntityModel<UserDto> entityModel =
                userAssembler.toModel(userMapper.toUserDto(userService.save(userMapper.toUser(userDto))));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
}
