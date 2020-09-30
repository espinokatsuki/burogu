package io.maya.burogu.controller;

import io.maya.burogu.dto.SubredditDto;
import io.maya.burogu.mapper.SubredditMapper;
import io.maya.burogu.service.ISubredditService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subreddit/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SubredditController {
    private ISubredditService subredditService;
    private SubredditMapper subredditMapper;

    public SubredditController(ISubredditService subredditService, SubredditMapper subredditMapper) {
        this.subredditService = subredditService;
        this.subredditMapper = subredditMapper;
    }

    @GetMapping
    public List<SubredditDto> getAll() {
        return subredditMapper.toSubredditDtos(subredditService.getAll());
    }

    @GetMapping("/communities")
    public CollectionModel<EntityModel<SubredditDto>> getCommunities() {
        return null;
    }
}
