package uz.pdp.dataabsemigration.serice;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dataabsemigration.servie.Users;

public interface AuthUserRepository extends JpaRepository<Users , Integer> {
}
