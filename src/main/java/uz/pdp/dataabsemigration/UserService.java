package uz.pdp.dataabsemigration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public Users createUser(String fullName, String email, String password) {
      return userRepository.save(new Users(fullName, email, password));
    }

    public Users getUserById(Integer id) {
        System.out.println("AA");
        return userRepository.findById(id).orElse(null);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
