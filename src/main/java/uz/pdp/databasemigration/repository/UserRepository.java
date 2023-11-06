package uz.pdp.databasemigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.databasemigration.entity.User;

public interface UserRepository extends JpaRepository<User , Integer> {
}
