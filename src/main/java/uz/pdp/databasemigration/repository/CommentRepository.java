package uz.pdp.databasemigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.databasemigration.entity.Comment;
import uz.pdp.databasemigration.entity.User;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
 void deleteAllByBlog_Id(Integer blog_id);
}
