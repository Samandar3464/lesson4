package uz.pdp.databasemigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
