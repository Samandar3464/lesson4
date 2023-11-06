package uz.pdp.databasemigration.service;

import uz.pdp.databasemigration.entity.User;
import uz.pdp.databasemigration.model.UserDto;

public interface UserService {

    User createUser(UserDto userDto);
    User updateUser(UserDto userDto);
}
