package io.maya.burogu.service;

import io.maya.burogu.model.Subreddit;

import java.util.List;
import java.util.Optional;

public interface ISubredditService {
    List<Subreddit> getAll();

    Optional<Subreddit> getById(Integer id);
}
