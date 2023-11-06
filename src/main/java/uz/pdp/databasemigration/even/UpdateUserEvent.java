package uz.pdp.databasemigration.even;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import uz.pdp.databasemigration.entity.User;

@Data
@RequiredArgsConstructor
public class UpdateUserEvent {
    private final User user;

}
