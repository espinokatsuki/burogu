package io.maya.burogu.service.postgres;

import io.maya.burogu.model.Post;
import io.maya.burogu.repository.PostRepository;
import io.maya.burogu.service.IPostService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostServiceImpl implements IPostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
