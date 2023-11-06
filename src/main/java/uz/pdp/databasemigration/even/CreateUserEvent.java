package uz.pdp.databasemigration.even;

import lombok.*;
import uz.pdp.databasemigration.entity.User;
@Data
@RequiredArgsConstructor
public class CreateUserEvent  {
    private final User user;

}
