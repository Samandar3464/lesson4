package uz.pdp.databasemigration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.databasemigration.entity.User;
import uz.pdp.databasemigration.model.UserDto;
import uz.pdp.databasemigration.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(UserDto dto) {
        return userService.createUser(dto);
    }

    @PutMapping
    public User update(UserDto dto) {
        return userService.updateUser(dto);
    }
}
