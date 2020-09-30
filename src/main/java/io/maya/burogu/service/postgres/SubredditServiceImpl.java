package io.maya.burogu.service.postgres;

import io.maya.burogu.model.Subreddit;
import io.maya.burogu.repository.SubredditRepository;
import io.maya.burogu.service.ISubredditService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class SubredditServiceImpl implements ISubredditService {
    private SubredditRepository subredditRepository;

    public SubredditServiceImpl(SubredditRepository subredditRepository) {
        this.subredditRepository = subredditRepository;
    }

    @Override
    public List<Subreddit> getAll() {
        return subredditRepository.findAll();
    }

    @Override
    public Optional<Subreddit> getById(Integer id) {
        return Optional.empty();
    }
}
