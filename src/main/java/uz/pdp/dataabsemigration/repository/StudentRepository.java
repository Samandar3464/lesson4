package uz.pdp.dataabsemigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dataabsemigration.entity.Student;

public interface StudentRepository extends JpaRepository<Student , Integer> {
}
