package uz.pdp.dataabsemigration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo ,Integer> {
    List<Todo>  findAllByLevel(Level level);
    List<Todo>  findAllByCategory(Category level);
}
