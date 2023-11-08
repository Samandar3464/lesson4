package uz.pdp.dataabsemigration.service;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dataabsemigration.entity.Student;

public interface PostRepository extends JpaRepository<Student , Integer> {
}
