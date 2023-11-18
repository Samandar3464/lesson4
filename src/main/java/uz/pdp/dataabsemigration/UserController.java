package uz.pdp.dataabsemigration;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MutationMapping
    public Users createUser(@Argument String fullName, @Argument String email, @Argument String password) {
        return userService.createUser(fullName, email, password);
    }

    @QueryMapping
    public Users getUserById(@Argument Integer id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

}
