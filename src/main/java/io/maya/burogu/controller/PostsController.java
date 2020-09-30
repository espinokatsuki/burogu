package io.maya.burogu.controller;

import io.maya.burogu.dto.PostDto;
import io.maya.burogu.mapper.PostMapper;
import io.maya.burogu.service.IPostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PostsController {
    private IPostService postService;
    private PostMapper postMapper;

    public PostsController(IPostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public List<PostDto> getAll() {
        return postMapper.toPostDtos(postService.getAll());
    }
}
