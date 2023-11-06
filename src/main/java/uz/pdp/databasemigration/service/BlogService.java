package uz.pdp.databasemigration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.even.DeleteBlogEvent;
import uz.pdp.databasemigration.mapper.BlogMapper;
import uz.pdp.databasemigration.model.BlogDto;
import uz.pdp.databasemigration.repository.BlogRepository;

import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final ApplicationEventPublisher publisher;

    public Blog create(BlogDto dto) {
        return blogRepository.save(blogMapper.toEntity(dto));
    }

    public Blog getById(Integer id) {
        return blogRepository.findById(id).orElseThrow();
    }

    public void delete(Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if (byId.isPresent()) {
            blogRepository.deleteById(id);
            publisher.publishEvent(new DeleteBlogEvent(byId.get()));
        }
    }
}
