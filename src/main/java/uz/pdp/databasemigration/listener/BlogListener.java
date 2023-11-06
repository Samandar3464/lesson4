package uz.pdp.databasemigration.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.even.DeleteBlogEvent;
import uz.pdp.databasemigration.even.SetBlogEvent;
import uz.pdp.databasemigration.repository.BlogRepository;
import uz.pdp.databasemigration.repository.CommentRepository;


@Component
@RequiredArgsConstructor
@EnableAsync
public class BlogListener {

    private final CommentRepository commentRepository;
private final BlogRepository blogRepository;
    @EventListener
    @Async
    public void deleteCommentsByBlogIdListener(DeleteBlogEvent event){
        Blog blog = event.getBlog();
        commentRepository.deleteAllByBlog_Id(blog.getId());

    }

    @EventListener

    public void addBlogToCommentListener(SetBlogEvent event){
        Blog blog = blogRepository.findById(event.getBlogId()).get();
        commentRepository.deleteAllByBlog_Id(blog.getId());
        event.getComment().setBlog(blog);
    }

}
