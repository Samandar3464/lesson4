package uz.pdp.databasemigration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import uz.pdp.databasemigration.entity.Comment;
import uz.pdp.databasemigration.even.SetBlogEvent;
import uz.pdp.databasemigration.mapper.CommentMapper;
import uz.pdp.databasemigration.model.CommentDto;
import uz.pdp.databasemigration.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ApplicationEventPublisher publisher;
    public Comment create(CommentDto dto) {
        Comment entity = commentMapper.toEntity(dto);
        publisher.publishEvent(new SetBlogEvent(dto.getBlogId(), entity));
        return   commentRepository.save(entity);
    }
}
